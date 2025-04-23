package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.UserRoleIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleUserNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserRoleAggregateTests extends BaseUnitTests {

@Test
void it_should_create_userRole_with_valid_values() {
	UserRoleId id = UserRoleId.create(UUID.randomUUID().toString());
	UserRoleUser user = UserRoleUser.create(UUID.randomUUID().toString());
	UserRoleRole role = UserRoleRole.create(UUID.randomUUID().toString());
	UserRoleAggregate userRole = new UserRoleAggregate(id, user, role);
	assertThat(userRole.getId()).isNotNull();
	assertThat(userRole.getId()).isEqualTo(id);
	assertThat(userRole.getUser()).isEqualTo(user);
	assertThat(userRole.getRole()).isEqualTo(role);
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

}
