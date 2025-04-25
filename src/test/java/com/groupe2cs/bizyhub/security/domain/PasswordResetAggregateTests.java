package com.groupe2cs.bizyhub.security.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;


public class PasswordResetAggregateTests extends BaseUnitTests {

@Test
void it_should_create_passwordReset_with_valid_values() {
	PasswordResetId id = PasswordResetId.create(UUID.randomUUID().toString());
	PasswordResetToken token = PasswordResetToken.create(UUID.randomUUID().toString());
	PasswordResetUsername username = PasswordResetUsername.create(UUID.randomUUID().toString());
	PasswordResetExpiration expiration = PasswordResetExpiration.create(java.time.Instant.now().plusSeconds(3600));
	PasswordResetCreatedBy createdBy = PasswordResetCreatedBy.create(UUID.randomUUID().toString());
	PasswordResetTenant tenant = PasswordResetTenant.create(UUID.randomUUID().toString());
	PasswordResetAggregate passwordReset = new PasswordResetAggregate(id, token, username, expiration, createdBy, tenant);
	assertThat(passwordReset.getId()).isNotNull();
	assertThat(passwordReset.getId()).isEqualTo(id);
	assertThat(passwordReset.getToken()).isEqualTo(token);
	assertThat(passwordReset.getUsername()).isEqualTo(username);
	assertThat(passwordReset.getExpiration()).isEqualTo(expiration);
	assertThat(passwordReset.getCreatedBy()).isEqualTo(createdBy);
	assertThat(passwordReset.getTenant()).isEqualTo(tenant);
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
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		PasswordResetCreatedByNotValid error = assertThrows(PasswordResetCreatedByNotValid.class, () -> PasswordResetCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		PasswordResetTenantNotValid error = assertThrows(PasswordResetTenantNotValid.class, () -> PasswordResetTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
