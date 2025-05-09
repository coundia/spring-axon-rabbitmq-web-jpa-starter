package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_user_with_valid_values() {
		UserId id = UserId.create(UUID.randomUUID().toString());
		UserUsername username = UserUsername.create(UUID.randomUUID().toString());
		UserPassword password = UserPassword.create(UUID.randomUUID().toString());
		UserCreatedBy createdBy = UserCreatedBy.create(UUID.randomUUID().toString());
		UserTenant tenant = UserTenant.create(UUID.randomUUID().toString());
		UserAggregate aggregateUserAggregate = new UserAggregate(id, username, password, createdBy, tenant);
		assertThat(aggregateUserAggregate.getId()).isNotNull();
		assertThat(aggregateUserAggregate.getId()).isEqualTo(id);
		assertThat(aggregateUserAggregate.getUsername()).isEqualTo(username);
		assertThat(aggregateUserAggregate.getPassword()).isEqualTo(password);
		assertThat(aggregateUserAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateUserAggregate.getTenant()).isEqualTo(tenant);
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
