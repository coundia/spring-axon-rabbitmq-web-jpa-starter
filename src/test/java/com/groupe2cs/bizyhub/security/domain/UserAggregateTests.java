package com.groupe2cs.bizyhub.security.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;


public class UserAggregateTests extends BaseUnitTests {

@Test
void it_should_create_user_with_valid_values() {
	UserId id = UserId.create(UUID.randomUUID().toString());
	UserUsername username = UserUsername.create(UUID.randomUUID().toString());
	UserPassword password = UserPassword.create(UUID.randomUUID().toString());
	UserCreatedBy createdBy = UserCreatedBy.create(UUID.randomUUID().toString());
	UserTenant tenant = UserTenant.create(UUID.randomUUID().toString());
	UserAggregate user = new UserAggregate(id, username, password, createdBy, tenant);
	assertThat(user.getId()).isNotNull();
	assertThat(user.getId()).isEqualTo(id);
	assertThat(user.getUsername()).isEqualTo(username);
	assertThat(user.getPassword()).isEqualTo(password);
	assertThat(user.getCreatedBy()).isEqualTo(createdBy);
	assertThat(user.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		UserIdNotValid error = assertThrows(UserIdNotValid.class, () -> UserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_username_is_invalid() {
		UserUsernameNotValid error = assertThrows(UserUsernameNotValid.class, () -> UserUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
		}
		@Test
		void it_should_throw_when_password_is_invalid() {
		UserPasswordNotValid error = assertThrows(UserPasswordNotValid.class, () -> UserPassword.create(""));
		assertThat(error.getMessage()).isEqualTo("Password is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		UserCreatedByNotValid error = assertThrows(UserCreatedByNotValid.class, () -> UserCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		UserTenantNotValid error = assertThrows(UserTenantNotValid.class, () -> UserTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
