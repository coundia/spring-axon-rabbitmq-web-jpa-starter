package com.groupe2cs.bizyhub.security.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;


public class RoleAggregateTests extends BaseUnitTests {

@Test
void it_should_create_role_with_valid_values() {
	RoleId id = RoleId.create(UUID.randomUUID().toString());
	RoleName name = RoleName.create(UUID.randomUUID().toString());
	RoleCreatedBy createdBy = RoleCreatedBy.create(UUID.randomUUID().toString());
	RoleTenant tenant = RoleTenant.create(UUID.randomUUID().toString());
	RoleAggregate role = new RoleAggregate(id, name, createdBy, tenant);
	assertThat(role.getId()).isNotNull();
	assertThat(role.getId()).isEqualTo(id);
	assertThat(role.getName()).isEqualTo(name);
	assertThat(role.getCreatedBy()).isEqualTo(createdBy);
	assertThat(role.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		RoleIdNotValid error = assertThrows(RoleIdNotValid.class, () -> RoleId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		RoleNameNotValid error = assertThrows(RoleNameNotValid.class, () -> RoleName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		RoleCreatedByNotValid error = assertThrows(RoleCreatedByNotValid.class, () -> RoleCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		RoleTenantNotValid error = assertThrows(RoleTenantNotValid.class, () -> RoleTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
