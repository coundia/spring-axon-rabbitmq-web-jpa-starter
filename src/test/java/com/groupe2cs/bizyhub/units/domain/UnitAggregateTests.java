package com.groupe2cs.bizyhub.units.domain;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.units.domain.exception.*;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class UnitAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_unit_with_valid_values() {
		UnitId id = UnitId.create(UUID.randomUUID().toString());
		UnitRemoteId remoteId = UnitRemoteId.create(UUID.randomUUID().toString());
		UnitLocalId localId = UnitLocalId.create(UUID.randomUUID().toString());
		UnitCode code = UnitCode.create(UUID.randomUUID().toString());
		UnitName name = UnitName.create(UUID.randomUUID().toString());
		UnitSyncAt syncAt = UnitSyncAt.create(java.time.Instant.now().plusSeconds(3600));
		UnitDescription description = UnitDescription.create(UUID.randomUUID().toString());
		UnitCreatedBy createdBy = UnitCreatedBy.create(UUID.randomUUID().toString());
		UnitTenant tenant = UnitTenant.create(UUID.randomUUID().toString());
		UnitAggregate
				aggregateUnitAggregate =
				new UnitAggregate(id, remoteId, localId, code, name, syncAt, description, createdBy, tenant);
		assertThat(aggregateUnitAggregate.getId()).isNotNull();
		assertThat(aggregateUnitAggregate.getId()).isEqualTo(id);
		assertThat(aggregateUnitAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateUnitAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateUnitAggregate.getCode()).isEqualTo(code);
		assertThat(aggregateUnitAggregate.getName()).isEqualTo(name);
		assertThat(aggregateUnitAggregate.getSyncAt()).isEqualTo(syncAt);
		assertThat(aggregateUnitAggregate.getDescription()).isEqualTo(description);
		assertThat(aggregateUnitAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateUnitAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		UnitIdNotValid error = assertThrows(UnitIdNotValid.class, () -> UnitId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

}
