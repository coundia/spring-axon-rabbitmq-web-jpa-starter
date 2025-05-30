package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionPermissionNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RolePermissionAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_rolePermission_with_valid_values() {
		RolePermissionId id = RolePermissionId.create(UUID.randomUUID().toString());
		RolePermissionRole role = RolePermissionRole.create(UUID.randomUUID().toString());
		RolePermissionPermission permission = RolePermissionPermission.create(UUID.randomUUID().toString());
		RolePermissionCreatedBy createdBy = RolePermissionCreatedBy.create(UUID.randomUUID().toString());
		RolePermissionTenant tenant = RolePermissionTenant.create(UUID.randomUUID().toString());
		RolePermissionAggregate
				aggregateRolePermissionAggregate =
				new RolePermissionAggregate(id, role, permission, createdBy, tenant);
		assertThat(aggregateRolePermissionAggregate.getId()).isNotNull();
		assertThat(aggregateRolePermissionAggregate.getId()).isEqualTo(id);
		assertThat(aggregateRolePermissionAggregate.getRole()).isEqualTo(role);
		assertThat(aggregateRolePermissionAggregate.getPermission()).isEqualTo(permission);
		assertThat(aggregateRolePermissionAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateRolePermissionAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		RolePermissionIdNotValid
				error =
				assertThrows(RolePermissionIdNotValid.class, () -> RolePermissionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_role_is_invalid() {
		RolePermissionRoleNotValid
				error =
				assertThrows(RolePermissionRoleNotValid.class, () -> RolePermissionRole.create(""));
		assertThat(error.getMessage()).isEqualTo("Role is invalid");
	}

	@Test
	void it_should_throw_when_permission_is_invalid() {
		RolePermissionPermissionNotValid
				error =
				assertThrows(RolePermissionPermissionNotValid.class, () -> RolePermissionPermission.create(""));
		assertThat(error.getMessage()).isEqualTo("Permission is invalid");
	}

}
