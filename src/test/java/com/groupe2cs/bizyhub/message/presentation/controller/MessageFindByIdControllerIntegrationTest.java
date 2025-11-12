package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.message.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class MessageFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private MessageRepository repository;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_get_message_by_id() {

	String existingId = MessageFixtures.randomOneViaCommand(
	commandGateway,repository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser()).getId().value();

	 MessageFixtures.byIdWaitExist(repository, existingId);

	String uri = "/v1/queries/message/id?id=" + existingId;
	ResponseEntity<MessageResponse> response = this.getForEntity(uri, MessageResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
