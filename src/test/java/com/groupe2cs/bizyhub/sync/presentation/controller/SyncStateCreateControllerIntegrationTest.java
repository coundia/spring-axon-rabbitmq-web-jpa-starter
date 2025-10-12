package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SyncStateCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_syncstate() {

		SyncStateRequest requestDTO = new SyncStateRequest();

		requestDTO.setEntityTable(UUID.randomUUID().toString());
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setLastSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setLastCursor(UUID.randomUUID().toString());

		String uri = "/v1/commands/syncState";
		ResponseEntity<SyncStateResponse> response = this.postForEntity(uri, requestDTO, SyncStateResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getEntityTable()).isEqualTo(requestDTO.getEntityTable());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getLastSyncAt()).isEqualTo(requestDTO.getLastSyncAt());
		assertThat(response.getBody().getLastCursor()).isEqualTo(requestDTO.getLastCursor());
	}
}
