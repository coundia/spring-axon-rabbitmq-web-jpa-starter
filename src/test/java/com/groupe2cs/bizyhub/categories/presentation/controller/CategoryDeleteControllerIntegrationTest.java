package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.categories.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class CategoryDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CategoryRepository categoryRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_category() {
	String existingId = CategoryFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

	CategoryFixtures.byIdWaitExist(categoryRepository, existingId);

	String uri = "/v1/commands/category/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Category found = CategoryFixtures.byIdWaitNotExist(categoryRepository, existingId);
	assertThat(found).isNull();
	}
}
