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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class MessageDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private MessageRepository messageRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_delete_message() {
	String existingId = MessageFixtures.randomOneViaCommand(commandGateway, messageRepository,
        createdByDataRepository,
        tenantDataRepository,
	getCurrentUser()).getId().value();

	MessageFixtures.byIdWaitExist(messageRepository, existingId);

	String uri = "/v1/commands/message/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Message found = MessageFixtures.byIdWaitNotExist(messageRepository, existingId);
	assertThat(found).isNull();
	}
}
