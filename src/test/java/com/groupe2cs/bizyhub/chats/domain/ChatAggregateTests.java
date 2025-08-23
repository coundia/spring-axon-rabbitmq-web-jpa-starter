package com.groupe2cs.bizyhub.chats.domain;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class ChatAggregateTests extends BaseUnitTests {

@Test
void it_should_create_chat_with_valid_values() {
	ChatId id = ChatId.create(UUID.randomUUID().toString());
	ChatMessages messages = ChatMessages.create(UUID.randomUUID().toString());
	ChatResponsesJson responsesJson = ChatResponsesJson.create(UUID.randomUUID().toString());
	ChatResponses responses = ChatResponses.create(UUID.randomUUID().toString());
	ChatState state = ChatState.create(UUID.randomUUID().toString());
	ChatSyncAt syncAt = ChatSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	ChatAccount account = ChatAccount.create(UUID.randomUUID().toString());
	ChatFiles files = ChatFiles.create(UUID.randomUUID().toString());
	ChatDateTransaction dateTransaction = ChatDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	ChatCreatedBy createdBy = ChatCreatedBy.create(UUID.randomUUID().toString());
	ChatTenant tenant = ChatTenant.create(UUID.randomUUID().toString());
	ChatAggregate aggregateChatAggregate = new ChatAggregate(id, messages, responsesJson, responses, state, syncAt, account, files, dateTransaction, createdBy, tenant);
	assertThat(aggregateChatAggregate.getId()).isNotNull();
	assertThat(aggregateChatAggregate.getId()).isEqualTo(id);
	assertThat(aggregateChatAggregate.getMessages()).isEqualTo(messages);
	assertThat(aggregateChatAggregate.getResponsesJson()).isEqualTo(responsesJson);
	assertThat(aggregateChatAggregate.getResponses()).isEqualTo(responses);
	assertThat(aggregateChatAggregate.getState()).isEqualTo(state);
	assertThat(aggregateChatAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateChatAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateChatAggregate.getFiles()).isEqualTo(files);
	assertThat(aggregateChatAggregate.getDateTransaction()).isEqualTo(dateTransaction);
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
