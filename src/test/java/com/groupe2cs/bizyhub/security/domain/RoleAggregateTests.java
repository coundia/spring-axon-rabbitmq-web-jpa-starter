package com.groupe2cs.bizyhub.security.domain;

import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;


public class RoleAggregateTests extends BaseUnitTests {

@Test
void it_should_create_role_with_valid_values() {
	RoleId id = RoleId.create(UUID.randomUUID().toString());
	RoleName name = RoleName.create(UUID.randomUUID().toString());
	RoleAggregate role = new RoleAggregate(id, name);
	assertThat(role.getId()).isNotNull();
	assertThat(role.getId()).isEqualTo(id);
	assertThat(role.getName()).isEqualTo(name);
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

}
