package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class TenantDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TenantRepository tenantRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_tenant() {
	String existingId = TenantFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

	TenantFixtures.byIdWaitExist(tenantRepository, existingId);

	String uri = "/v1/admin/commands/tenant/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Tenant found = TenantFixtures.byIdWaitNotExist(tenantRepository, existingId);
	assertThat(found).isNull();
	}
}
