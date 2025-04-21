package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
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
		UserAggregate user = new UserAggregate(id, username, password);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getId()).isEqualTo(id);
		assertThat(user.getUsername()).isEqualTo(username);
		assertThat(user.getPassword()).isEqualTo(password);
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

}
