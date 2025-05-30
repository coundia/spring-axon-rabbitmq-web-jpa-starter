package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.settings.application.dto.SettingRequest;
import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_setting() {

		SettingRequest requestDTO = new SettingRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setValue(UUID.randomUUID().toString());
		requestDTO.setLocale(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);

		String uri = "/v1/commands/setting";
		ResponseEntity<SettingResponse> response = this.postForEntity(uri, requestDTO, SettingResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getValue()).isEqualTo(requestDTO.getValue());
		assertThat(response.getBody().getLocale()).isEqualTo(requestDTO.getLocale());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
