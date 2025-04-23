package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetUsername;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PasswordResetAggregateTests extends BaseUnitTests {

@Test
void it_should_create_passwordReset_with_valid_values() {
	PasswordResetId id = PasswordResetId.create(UUID.randomUUID().toString());
	PasswordResetToken token = PasswordResetToken.create(UUID.randomUUID().toString());
	PasswordResetUsername username = PasswordResetUsername.create(UUID.randomUUID().toString());
	PasswordResetExpiration expiration = PasswordResetExpiration.create(java.time.Instant.now().plusSeconds(3600));
	PasswordResetAggregate passwordReset = new PasswordResetAggregate(id, token, username, expiration);
	assertThat(passwordReset.getId()).isNotNull();
	assertThat(passwordReset.getId()).isEqualTo(id);
	assertThat(passwordReset.getToken()).isEqualTo(token);
	assertThat(passwordReset.getUsername()).isEqualTo(username);
	assertThat(passwordReset.getExpiration()).isEqualTo(expiration);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		PasswordResetIdNotValid error = assertThrows(PasswordResetIdNotValid.class, () -> PasswordResetId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_token_is_invalid() {
		PasswordResetTokenNotValid error = assertThrows(PasswordResetTokenNotValid.class, () -> PasswordResetToken.create(""));
		assertThat(error.getMessage()).isEqualTo("Token is invalid");
		}
		@Test
		void it_should_throw_when_username_is_invalid() {
		PasswordResetUsernameNotValid error = assertThrows(PasswordResetUsernameNotValid.class, () -> PasswordResetUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
		}
		@Test
		void it_should_throw_when_expiration_is_invalid() {
		PasswordResetExpirationNotValid error = assertThrows(PasswordResetExpirationNotValid.class, () -> PasswordResetExpiration.create(null));
		assertThat(error.getMessage()).isEqualTo("Expiration is invalid");
		}

}
