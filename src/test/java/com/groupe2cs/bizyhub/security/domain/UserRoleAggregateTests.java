package com.groupe2cs.bizyhub.security.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;


public class UserRoleAggregateTests extends BaseUnitTests {

@Test
void it_should_create_userRole_with_valid_values() {
	UserRoleId id = UserRoleId.create(UUID.randomUUID().toString());
	UserRoleUser user = UserRoleUser.create(UUID.randomUUID().toString());
	UserRoleRole role = UserRoleRole.create(UUID.randomUUID().toString());
	UserRoleCreatedBy createdBy = UserRoleCreatedBy.create(UUID.randomUUID().toString());
	UserRoleTenant tenant = UserRoleTenant.create(UUID.randomUUID().toString());
	UserRoleAggregate aggregateUserRoleAggregate = new UserRoleAggregate(id, user, role, createdBy, tenant);
	assertThat(aggregateUserRoleAggregate.getId()).isNotNull();
	assertThat(aggregateUserRoleAggregate.getId()).isEqualTo(id);
	assertThat(aggregateUserRoleAggregate.getUser()).isEqualTo(user);
	assertThat(aggregateUserRoleAggregate.getRole()).isEqualTo(role);
	assertThat(aggregateUserRoleAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateUserRoleAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		UserRoleIdNotValid error = assertThrows(UserRoleIdNotValid.class, () -> UserRoleId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_user_is_invalid() {
		UserRoleUserNotValid error = assertThrows(UserRoleUserNotValid.class, () -> UserRoleUser.create(""));
		assertThat(error.getMessage()).isEqualTo("User is invalid");
		}
		@Test
		void it_should_throw_when_role_is_invalid() {
		UserRoleRoleNotValid error = assertThrows(UserRoleRoleNotValid.class, () -> UserRoleRole.create(""));
		assertThat(error.getMessage()).isEqualTo("Role is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		UserRoleCreatedByNotValid error = assertThrows(UserRoleCreatedByNotValid.class, () -> UserRoleCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		UserRoleTenantNotValid error = assertThrows(UserRoleTenantNotValid.class, () -> UserRoleTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
