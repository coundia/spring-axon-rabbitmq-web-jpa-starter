package com.groupe2cs.bizyhub.accounts.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_accountuser() {

		AccountUserRequest requestDTO = new AccountUserRequest();

		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setUser(UUID.randomUUID().toString());
		requestDTO.setPhone(UUID.randomUUID().toString());
		requestDTO.setRole(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setInvitedBy(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setAcceptedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setRevokedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setMessage(UUID.randomUUID().toString());
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);

 		String uri = "/v1/commands/accountUser";
		ResponseEntity<AccountUserResponse> response = this.postForEntity(uri, requestDTO, AccountUserResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getUser()).isEqualTo(requestDTO.getUser());
		assertThat(response.getBody().getPhone()).isEqualTo(requestDTO.getPhone());
		assertThat(response.getBody().getRole()).isEqualTo(requestDTO.getRole());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getInvitedBy()).isEqualTo(requestDTO.getInvitedBy());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getAcceptedAt()).isEqualTo(requestDTO.getAcceptedAt());
		assertThat(response.getBody().getRevokedAt()).isEqualTo(requestDTO.getRevokedAt());
		assertThat(response.getBody().getMessage()).isEqualTo(requestDTO.getMessage());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
