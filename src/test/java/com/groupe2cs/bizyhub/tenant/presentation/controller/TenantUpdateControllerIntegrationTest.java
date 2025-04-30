package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.application.command.CreateTenantCommand;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantRequest;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TenantUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_tenant() {

		String existingId = TenantFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		CreateTenantCommand updated = TenantFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

		TenantFixtures.byIdWaitExist(tenantRepository, existingId);
		TenantFixtures.byIdWaitExist(tenantRepository, updated.getId().value());

		TenantRequest requestDTO = new TenantRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setDomain(UUID.randomUUID().toString());
		requestDTO.setLanguage(UUID.randomUUID().toString());
		requestDTO.setActive(false);

		String uri = "/v1/admin/commands/tenant/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
