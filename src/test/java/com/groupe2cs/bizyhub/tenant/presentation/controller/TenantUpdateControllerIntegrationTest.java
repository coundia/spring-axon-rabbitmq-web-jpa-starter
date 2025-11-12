package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.application.command.CreateTenantCommand;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TenantUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private TenantRepository tenantDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;

	@Test
	void it_should_be_able_to_update_tenant() {

		String existingId = TenantFixtures.randomOneViaCommand(
				commandGateway, tenantRepository,
				tenantDataRepository,
				createdByDataRepository,
				getCurrentUser()
		).getId().value();

		CreateTenantCommand updated = TenantFixtures.randomOneViaCommand(
				commandGatewayUpdate, tenantRepository,
				tenantDataRepository,
				createdByDataRepository,
				getCurrentUser()
		);

		TenantFixtures.byIdWaitExist(tenantRepository, existingId);
		TenantFixtures.byIdWaitExist(tenantRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("name", UUID.randomUUID().toString());
		body.add("description", UUID.randomUUID().toString());
		body.add("domain", UUID.randomUUID().toString());
		body.add("language", UUID.randomUUID().toString());
		body.add("active", false);

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/admin/commands/tenant/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
