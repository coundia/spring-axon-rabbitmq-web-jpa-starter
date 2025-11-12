package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.infrastructure.entity.Message;
import com.groupe2cs.bizyhub.message.infrastructure.entity.MessageFixtures;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

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
