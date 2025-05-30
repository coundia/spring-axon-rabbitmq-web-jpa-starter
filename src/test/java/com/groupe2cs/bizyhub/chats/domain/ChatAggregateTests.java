package com.groupe2cs.bizyhub.chats.domain;

import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ChatAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_chat_with_valid_values() {
		ChatId id = ChatId.create(UUID.randomUUID().toString());
		ChatMessages messages = ChatMessages.create(UUID.randomUUID().toString());
		ChatResponsesJson responsesJson = ChatResponsesJson.create(UUID.randomUUID().toString());
		ChatResponses responses = ChatResponses.create(UUID.randomUUID().toString());
		ChatState state = ChatState.create(UUID.randomUUID().toString());
		ChatAccount account = ChatAccount.create(UUID.randomUUID().toString());
		ChatFiles files = ChatFiles.create(UUID.randomUUID().toString());
		ChatCreatedBy createdBy = ChatCreatedBy.create(UUID.randomUUID().toString());
		ChatTenant tenant = ChatTenant.create(UUID.randomUUID().toString());
		ChatAggregate
				aggregateChatAggregate =
				new ChatAggregate(id, messages, responsesJson, responses, state, account, files, createdBy, tenant);
		assertThat(aggregateChatAggregate.getId()).isNotNull();
		assertThat(aggregateChatAggregate.getId()).isEqualTo(id);
		assertThat(aggregateChatAggregate.getMessages()).isEqualTo(messages);
		assertThat(aggregateChatAggregate.getResponsesJson()).isEqualTo(responsesJson);
		assertThat(aggregateChatAggregate.getResponses()).isEqualTo(responses);
		assertThat(aggregateChatAggregate.getState()).isEqualTo(state);
		assertThat(aggregateChatAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateChatAggregate.getFiles()).isEqualTo(files);
		assertThat(aggregateChatAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateChatAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		ChatIdNotValid error = assertThrows(ChatIdNotValid.class, () -> ChatId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_messages_is_invalid() {
		ChatMessagesNotValid error = assertThrows(ChatMessagesNotValid.class, () -> ChatMessages.create(""));
		assertThat(error.getMessage()).isEqualTo("Messages is invalid");
	}

}
