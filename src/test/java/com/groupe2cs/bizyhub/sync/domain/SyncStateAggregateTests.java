package com.groupe2cs.bizyhub.sync.domain;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SyncStateAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_syncState_with_valid_values() {
		SyncStateId id = SyncStateId.create(UUID.randomUUID().toString());
		SyncStateEntityTable entityTable = SyncStateEntityTable.create(UUID.randomUUID().toString());
		SyncStateRemoteId remoteId = SyncStateRemoteId.create(UUID.randomUUID().toString());
		SyncStateLocalId localId = SyncStateLocalId.create(UUID.randomUUID().toString());
		SyncStateAccount account = SyncStateAccount.create(UUID.randomUUID().toString());
		SyncStateSyncAt syncAt = SyncStateSyncAt.create(java.time.Instant.now().plusSeconds(3600));
		SyncStateLastSyncAt lastSyncAt = SyncStateLastSyncAt.create(java.time.Instant.now().plusSeconds(3600));
		SyncStateLastCursor lastCursor = SyncStateLastCursor.create(UUID.randomUUID().toString());
		SyncStateCreatedBy createdBy = SyncStateCreatedBy.create(UUID.randomUUID().toString());
		SyncStateTenant tenant = SyncStateTenant.create(UUID.randomUUID().toString());
		SyncStateAggregate
				aggregateSyncStateAggregate =
				new SyncStateAggregate(id,
						entityTable,
						remoteId,
						localId,
						account,
						syncAt,
						lastSyncAt,
						lastCursor,
						createdBy,
						tenant);
		assertThat(aggregateSyncStateAggregate.getId()).isNotNull();
		assertThat(aggregateSyncStateAggregate.getId()).isEqualTo(id);
		assertThat(aggregateSyncStateAggregate.getEntityTable()).isEqualTo(entityTable);
		assertThat(aggregateSyncStateAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateSyncStateAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateSyncStateAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateSyncStateAggregate.getSyncAt()).isEqualTo(syncAt);
		assertThat(aggregateSyncStateAggregate.getLastSyncAt()).isEqualTo(lastSyncAt);
		assertThat(aggregateSyncStateAggregate.getLastCursor()).isEqualTo(lastCursor);
		assertThat(aggregateSyncStateAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateSyncStateAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		SyncStateIdNotValid error = assertThrows(SyncStateIdNotValid.class, () -> SyncStateId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_entityTable_is_invalid() {
		SyncStateEntityTableNotValid
				error =
				assertThrows(SyncStateEntityTableNotValid.class, () -> SyncStateEntityTable.create(""));
		assertThat(error.getMessage()).isEqualTo("EntityTable is invalid");
	}

}
