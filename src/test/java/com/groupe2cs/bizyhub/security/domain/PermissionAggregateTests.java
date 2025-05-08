package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.shared.*;


public class PermissionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_permission_with_valid_values() {
	PermissionId id = PermissionId.create(UUID.randomUUID().toString());
	PermissionName name = PermissionName.create(UUID.randomUUID().toString());
	PermissionCreatedBy createdBy = PermissionCreatedBy.create(UUID.randomUUID().toString());
	PermissionTenant tenant = PermissionTenant.create(UUID.randomUUID().toString());
	PermissionAggregate aggregatePermissionAggregate = new PermissionAggregate(id, name, createdBy, tenant);
	assertThat(aggregatePermissionAggregate.getId()).isNotNull();
	assertThat(aggregatePermissionAggregate.getId()).isEqualTo(id);
	assertThat(aggregatePermissionAggregate.getName()).isEqualTo(name);
	assertThat(aggregatePermissionAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregatePermissionAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		PermissionIdNotValid error = assertThrows(PermissionIdNotValid.class, () -> PermissionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		PermissionNameNotValid error = assertThrows(PermissionNameNotValid.class, () -> PermissionName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		PermissionCreatedByNotValid error = assertThrows(PermissionCreatedByNotValid.class, () -> PermissionCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		PermissionTenantNotValid error = assertThrows(PermissionTenantNotValid.class, () -> PermissionTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
