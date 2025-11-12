package com.groupe2cs.bizyhub.message.domain;

import java.util.UUID;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.message.domain.exception.*;


public class MessageAggregateTests extends BaseUnitTests {

@Test
void it_should_create_message_with_valid_values() {
    MessageId id = MessageId.create(UUID.randomUUID().toString());
    MessageCode code = MessageCode.create(UUID.randomUUID().toString());
    MessageEmail email = MessageEmail.create(UUID.randomUUID().toString());
    MessagePhone phone = MessagePhone.create(UUID.randomUUID().toString());
    MessageContent content = MessageContent.create(UUID.randomUUID().toString());
    MessagePlateforme plateforme = MessagePlateforme.create(UUID.randomUUID().toString());
    MessageSource source = MessageSource.create(UUID.randomUUID().toString());
    MessageAgent agent = MessageAgent.create(UUID.randomUUID().toString());
    MessageStatus status = MessageStatus.create(UUID.randomUUID().toString());
    MessageDescription description = MessageDescription.create(UUID.randomUUID().toString());
    MessageIsActive isActive = MessageIsActive.create(false);
    MessageIsDefault isDefault = MessageIsDefault.create(false);
    MessageRemoteId remoteId = MessageRemoteId.create(UUID.randomUUID().toString());
    MessageLocalId localId = MessageLocalId.create(UUID.randomUUID().toString());
    MessageDepotAt depotAt = MessageDepotAt.create(java.time.Instant.now().plusSeconds(3600));
    MessageSyncAt syncAt = MessageSyncAt.create(java.time.Instant.now().plusSeconds(3600));
    MessageCreatedBy createdBy = MessageCreatedBy.create(UUID.randomUUID().toString());
    MessageTenant tenant = MessageTenant.create(UUID.randomUUID().toString());
MessageAggregate aggregateMessageAggregate = new MessageAggregate(id, code, email, phone, content, plateforme, source, agent, status, description, isActive, isDefault, remoteId, localId, depotAt, syncAt, createdBy, tenant);
	assertThat(aggregateMessageAggregate.getId()).isNotNull();
	assertThat(aggregateMessageAggregate.getId()).isEqualTo(id);
	assertThat(aggregateMessageAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateMessageAggregate.getEmail()).isEqualTo(email);
	assertThat(aggregateMessageAggregate.getPhone()).isEqualTo(phone);
	assertThat(aggregateMessageAggregate.getContent()).isEqualTo(content);
	assertThat(aggregateMessageAggregate.getPlateforme()).isEqualTo(plateforme);
	assertThat(aggregateMessageAggregate.getSource()).isEqualTo(source);
	assertThat(aggregateMessageAggregate.getAgent()).isEqualTo(agent);
	assertThat(aggregateMessageAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateMessageAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateMessageAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateMessageAggregate.getIsDefault()).isEqualTo(isDefault);
	assertThat(aggregateMessageAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateMessageAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateMessageAggregate.getDepotAt()).isEqualTo(depotAt);
	assertThat(aggregateMessageAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateMessageAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateMessageAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		MessageIdNotValid error = assertThrows(MessageIdNotValid.class, () -> MessageId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}

}
