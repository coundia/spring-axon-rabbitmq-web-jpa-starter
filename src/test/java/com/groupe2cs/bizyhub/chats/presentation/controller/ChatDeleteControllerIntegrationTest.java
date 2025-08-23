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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class ChatDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ChatRepository chatRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
@Autowired
private FileManagerRepository filesDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_delete_chat() {
	String existingId = ChatFixtures.randomOneViaCommand(commandGateway, chatRepository,
        accountDataRepository,
        filesDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	getCurrentUser()).getId().value();

	ChatFixtures.byIdWaitExist(chatRepository, existingId);

	String uri = "/v1/commands/chat/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Chat found = ChatFixtures.byIdWaitNotExist(chatRepository, existingId);
	assertThat(found).isNull();
	}
}
