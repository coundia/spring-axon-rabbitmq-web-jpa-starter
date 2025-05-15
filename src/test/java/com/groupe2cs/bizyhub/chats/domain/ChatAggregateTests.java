package com.groupe2cs.bizyhub.chats.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.domain.exception.*;


public class ChatAggregateTests extends BaseUnitTests {

@Test
void it_should_create_chat_with_valid_values() {
	ChatId id = ChatId.create(UUID.randomUUID().toString());
	ChatMessages messages = ChatMessages.create(UUID.randomUUID().toString());
	ChatResponsesJson responsesJson = ChatResponsesJson.create(UUID.randomUUID().toString());
	ChatResponses responses = ChatResponses.create(UUID.randomUUID().toString());
	ChatState state = ChatState.create(UUID.randomUUID().toString());
	ChatAccount account = ChatAccount.create(UUID.randomUUID().toString());
	ChatUpdatedAt updatedAt = ChatUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	ChatReference reference = ChatReference.create(UUID.randomUUID().toString());
	ChatCreatedBy createdBy = ChatCreatedBy.create(UUID.randomUUID().toString());
	ChatTenant tenant = ChatTenant.create(UUID.randomUUID().toString());
	ChatAggregate aggregateChatAggregate = new ChatAggregate(id, messages, responsesJson, responses, state, account, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateChatAggregate.getId()).isNotNull();
	assertThat(aggregateChatAggregate.getId()).isEqualTo(id);
	assertThat(aggregateChatAggregate.getMessages()).isEqualTo(messages);
	assertThat(aggregateChatAggregate.getResponsesJson()).isEqualTo(responsesJson);
	assertThat(aggregateChatAggregate.getResponses()).isEqualTo(responses);
	assertThat(aggregateChatAggregate.getState()).isEqualTo(state);
	assertThat(aggregateChatAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateChatAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateChatAggregate.getReference()).isEqualTo(reference);
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
		@Test
		void it_should_throw_when_responsesJson_is_invalid() {
		ChatResponsesJsonNotValid error = assertThrows(ChatResponsesJsonNotValid.class, () -> ChatResponsesJson.create(""));
		assertThat(error.getMessage()).isEqualTo("ResponsesJson is invalid");
		}
		@Test
		void it_should_throw_when_responses_is_invalid() {
		ChatResponsesNotValid error = assertThrows(ChatResponsesNotValid.class, () -> ChatResponses.create(""));
		assertThat(error.getMessage()).isEqualTo("Responses is invalid");
		}
		@Test
		void it_should_throw_when_state_is_invalid() {
		ChatStateNotValid error = assertThrows(ChatStateNotValid.class, () -> ChatState.create(""));
		assertThat(error.getMessage()).isEqualTo("State is invalid");
		}
		@Test
		void it_should_throw_when_account_is_invalid() {
		ChatAccountNotValid error = assertThrows(ChatAccountNotValid.class, () -> ChatAccount.create(""));
		assertThat(error.getMessage()).isEqualTo("Account is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		ChatUpdatedAtNotValid error = assertThrows(ChatUpdatedAtNotValid.class, () -> ChatUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		ChatReferenceNotValid error = assertThrows(ChatReferenceNotValid.class, () -> ChatReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		ChatCreatedByNotValid error = assertThrows(ChatCreatedByNotValid.class, () -> ChatCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		ChatTenantNotValid error = assertThrows(ChatTenantNotValid.class, () -> ChatTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
