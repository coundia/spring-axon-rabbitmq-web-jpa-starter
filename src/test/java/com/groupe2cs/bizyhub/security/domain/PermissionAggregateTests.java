package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.PermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionNameNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PermissionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_permission_with_valid_values() {
	PermissionId id = PermissionId.create(UUID.randomUUID().toString());
	PermissionName name = PermissionName.create(UUID.randomUUID().toString());
	PermissionAggregate permission = new PermissionAggregate(id, name);
	assertThat(permission.getId()).isNotNull();
	assertThat(permission.getId()).isEqualTo(id);
	assertThat(permission.getName()).isEqualTo(name);
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

}
