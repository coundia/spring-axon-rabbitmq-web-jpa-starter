package com.groupe2cs.bizyhub.sync.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.sync.domain.exception.*;


public class ChangeLogAggregateTests extends BaseUnitTests {

@Test
void it_should_create_changeLog_with_valid_values() {
	ChangeLogId id = ChangeLogId.create(UUID.randomUUID().toString());
	ChangeLogEntityTable entityTable = ChangeLogEntityTable.create(UUID.randomUUID().toString());
	ChangeLogEntityId entityId = ChangeLogEntityId.create(UUID.randomUUID().toString());
	ChangeLogRemoteId remoteId = ChangeLogRemoteId.create(UUID.randomUUID().toString());
	ChangeLogLocalId localId = ChangeLogLocalId.create(UUID.randomUUID().toString());
	ChangeLogOperation operation = ChangeLogOperation.create(UUID.randomUUID().toString());
	ChangeLogPayload payload = ChangeLogPayload.create(UUID.randomUUID().toString());
	ChangeLogStatus status = ChangeLogStatus.create(UUID.randomUUID().toString());
	ChangeLogSyncAt syncAt = ChangeLogSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	ChangeLogAttempts attempts = ChangeLogAttempts.create(18);
	ChangeLogError error = ChangeLogError.create(UUID.randomUUID().toString());
	ChangeLogCreatedBy createdBy = ChangeLogCreatedBy.create(UUID.randomUUID().toString());
	ChangeLogTenant tenant = ChangeLogTenant.create(UUID.randomUUID().toString());
	ChangeLogAggregate aggregateChangeLogAggregate = new ChangeLogAggregate(id, entityTable, entityId, remoteId, localId, operation, payload, status, syncAt, attempts, error, createdBy, tenant);
	assertThat(aggregateChangeLogAggregate.getId()).isNotNull();
	assertThat(aggregateChangeLogAggregate.getId()).isEqualTo(id);
	assertThat(aggregateChangeLogAggregate.getEntityTable()).isEqualTo(entityTable);
	assertThat(aggregateChangeLogAggregate.getEntityId()).isEqualTo(entityId);
	assertThat(aggregateChangeLogAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateChangeLogAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateChangeLogAggregate.getOperation()).isEqualTo(operation);
	assertThat(aggregateChangeLogAggregate.getPayload()).isEqualTo(payload);
	assertThat(aggregateChangeLogAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateChangeLogAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateChangeLogAggregate.getAttempts()).isEqualTo(attempts);
	assertThat(aggregateChangeLogAggregate.getError()).isEqualTo(error);
	assertThat(aggregateChangeLogAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateChangeLogAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		ChangeLogIdNotValid error = assertThrows(ChangeLogIdNotValid.class, () -> ChangeLogId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_entityTable_is_invalid() {
		ChangeLogEntityTableNotValid error = assertThrows(ChangeLogEntityTableNotValid.class, () -> ChangeLogEntityTable.create(""));
		assertThat(error.getMessage()).isEqualTo("EntityTable is invalid");
		}
		@Test
		void it_should_throw_when_entityId_is_invalid() {
		ChangeLogEntityIdNotValid error = assertThrows(ChangeLogEntityIdNotValid.class, () -> ChangeLogEntityId.create(""));
		assertThat(error.getMessage()).isEqualTo("EntityId is invalid");
		}
		@Test
		void it_should_throw_when_attempts_is_invalid() {
		ChangeLogAttemptsNotValid error = assertThrows(ChangeLogAttemptsNotValid.class, () -> ChangeLogAttempts.create(-1));
		assertThat(error.getMessage()).isEqualTo("Attempts is invalid");
		}

}
