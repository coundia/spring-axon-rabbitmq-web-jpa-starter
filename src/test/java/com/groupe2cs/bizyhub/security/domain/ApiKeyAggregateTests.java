package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApiKeyAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_apiKey_with_valid_values() {
		ApiKeyId id = ApiKeyId.create(UUID.randomUUID().toString());
		ApiKeyKey key = ApiKeyKey.create(UUID.randomUUID().toString());
		ApiKeyUsername username = ApiKeyUsername.create(UUID.randomUUID().toString());
		ApiKeyCreatedAt createdAt = ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600));
		ApiKeyExpiration expiration = ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600));
		ApiKeyCreatedBy createdBy = ApiKeyCreatedBy.create(UUID.randomUUID().toString());
		ApiKeyAggregate apiKey = new ApiKeyAggregate(id, key, username, createdAt, expiration, createdBy);
		assertThat(apiKey.getId()).isNotNull();
		assertThat(apiKey.getId()).isEqualTo(id);
		assertThat(apiKey.getKey()).isEqualTo(key);
		assertThat(apiKey.getUsername()).isEqualTo(username);
		assertThat(apiKey.getCreatedAt()).isEqualTo(createdAt);
		assertThat(apiKey.getExpiration()).isEqualTo(expiration);
		assertThat(apiKey.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		ApiKeyIdNotValid error = assertThrows(ApiKeyIdNotValid.class, () -> ApiKeyId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_key_is_invalid() {
		ApiKeyKeyNotValid error = assertThrows(ApiKeyKeyNotValid.class, () -> ApiKeyKey.create(""));
		assertThat(error.getMessage()).isEqualTo("Key is invalid");
	}

	@Test
	void it_should_throw_when_username_is_invalid() {
		ApiKeyUsernameNotValid error = assertThrows(ApiKeyUsernameNotValid.class, () -> ApiKeyUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
	}

	@Test
	void it_should_throw_when_createdAt_is_invalid() {
		ApiKeyCreatedAtNotValid error = assertThrows(ApiKeyCreatedAtNotValid.class, () -> ApiKeyCreatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("CreatedAt is invalid");
	}

	@Test
	void it_should_throw_when_expiration_is_invalid() {
		ApiKeyExpirationNotValid
				error =
				assertThrows(ApiKeyExpirationNotValid.class, () -> ApiKeyExpiration.create(null));
		assertThat(error.getMessage()).isEqualTo("Expiration is invalid");
	}

	@Test
	void it_should_throw_when_createdBy_is_invalid() {
		ApiKeyCreatedByNotValid error = assertThrows(ApiKeyCreatedByNotValid.class, () -> ApiKeyCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
	}

}
