package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.chats.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class ChatUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ChatRepository chatRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_chat() {

	String existingId = ChatFixtures.randomOneViaCommand(
	commandGateway,chatRepository,
        accountDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateChatCommand updated = ChatFixtures.randomOneViaCommand(commandGatewayUpdate,
    chatRepository,
            accountDataRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	ChatFixtures.byIdWaitExist(chatRepository, existingId);
	ChatFixtures.byIdWaitExist(chatRepository, updated.getId().value());

	ChatRequest requestDTO = new ChatRequest();
	 requestDTO.setMessages(UUID.randomUUID().toString());
	 requestDTO.setResponsesJson(UUID.randomUUID().toString());
	 requestDTO.setResponses(UUID.randomUUID().toString());
	 requestDTO.setState(UUID.randomUUID().toString());
	 requestDTO.setAccount( updated.getAccount().value());
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/chat/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
