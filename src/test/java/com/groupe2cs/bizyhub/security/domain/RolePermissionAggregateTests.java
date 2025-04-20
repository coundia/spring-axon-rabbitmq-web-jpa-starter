package com.groupe2cs.bizyhub.security.domain;

import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;


public class RolePermissionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_rolePermission_with_valid_values() {
	RolePermissionId id = RolePermissionId.create(UUID.randomUUID().toString());
	RolePermissionRole role = RolePermissionRole.create(UUID.randomUUID().toString());
	RolePermissionPermission permission = RolePermissionPermission.create(UUID.randomUUID().toString());
	RolePermissionAggregate rolePermission = new RolePermissionAggregate(id, role, permission);
	assertThat(rolePermission.getId()).isNotNull();
	assertThat(rolePermission.getId()).isEqualTo(id);
	assertThat(rolePermission.getRole()).isEqualTo(role);
	assertThat(rolePermission.getPermission()).isEqualTo(permission);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		RolePermissionIdNotValid error = assertThrows(RolePermissionIdNotValid.class, () -> RolePermissionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_role_is_invalid() {
		RolePermissionRoleNotValid error = assertThrows(RolePermissionRoleNotValid.class, () -> RolePermissionRole.create(""));
		assertThat(error.getMessage()).isEqualTo("Role is invalid");
		}
		@Test
		void it_should_throw_when_permission_is_invalid() {
		RolePermissionPermissionNotValid error = assertThrows(RolePermissionPermissionNotValid.class, () -> RolePermissionPermission.create(""));
		assertThat(error.getMessage()).isEqualTo("Permission is invalid");
		}

}
