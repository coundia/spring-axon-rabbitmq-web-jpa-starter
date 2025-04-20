package com.groupe2cs.bizyhub.security.domain;

import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;


public class UserAggregateTests extends BaseUnitTests {

@Test
void it_should_create_user_with_valid_values() {
	UserId id = UserId.create(UUID.randomUUID().toString());
	UserUsername username = UserUsername.create(UUID.randomUUID().toString());
	UserPassword password = UserPassword.create(UUID.randomUUID().toString());
	UserEmail email = UserEmail.create(UUID.randomUUID().toString());
	UserAggregate user = new UserAggregate(id, username, password, email);
	assertThat(user.getId()).isNotNull();
	assertThat(user.getId()).isEqualTo(id);
	assertThat(user.getUsername()).isEqualTo(username);
	assertThat(user.getPassword()).isEqualTo(password);
	assertThat(user.getEmail()).isEqualTo(email);
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
		void it_should_throw_when_email_is_invalid() {
		UserEmailNotValid error = assertThrows(UserEmailNotValid.class, () -> UserEmail.create(""));
		assertThat(error.getMessage()).isEqualTo("Email is invalid");
		}

}
