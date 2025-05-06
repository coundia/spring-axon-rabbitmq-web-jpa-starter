package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.sales.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class SaleUserDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SaleUserRepository saleuserRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_saleuser() {
	String existingId = SaleUserFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

	SaleUserFixtures.byIdWaitExist(saleuserRepository, existingId);

	String uri = "/v1/commands/saleUser/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	SaleUser found = SaleUserFixtures.byIdWaitNotExist(saleuserRepository, existingId);
	assertThat(found).isNull();
	}
}
