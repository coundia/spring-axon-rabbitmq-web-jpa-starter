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
		ApiKeyAppKey appKey = ApiKeyAppKey.create(UUID.randomUUID().toString());
		ApiKeyUsername username = ApiKeyUsername.create(UUID.randomUUID().toString());
		ApiKeyActive active = ApiKeyActive.create(true);
		ApiKeyCreatedAt createdAt = ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600));
		ApiKeyExpiration expiration = ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600));
		ApiKeyCreatedBy createdBy = ApiKeyCreatedBy.create(UUID.randomUUID().toString());
		ApiKeyTenant tenant = ApiKeyTenant.create(UUID.randomUUID().toString());
		ApiKeyAggregate
				aggregateApiKeyAggregate =
				new ApiKeyAggregate(id, appKey, username, active, createdAt, expiration, createdBy, tenant);
		assertThat(aggregateApiKeyAggregate.getId()).isNotNull();
		assertThat(aggregateApiKeyAggregate.getId()).isEqualTo(id);
		assertThat(aggregateApiKeyAggregate.getAppKey()).isEqualTo(appKey);
		assertThat(aggregateApiKeyAggregate.getUsername()).isEqualTo(username);
		assertThat(aggregateApiKeyAggregate.getActive()).isEqualTo(active);
		assertThat(aggregateApiKeyAggregate.getCreatedAt()).isEqualTo(createdAt);
		assertThat(aggregateApiKeyAggregate.getExpiration()).isEqualTo(expiration);
		assertThat(aggregateApiKeyAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateApiKeyAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		ApiKeyIdNotValid error = assertThrows(ApiKeyIdNotValid.class, () -> ApiKeyId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_appKey_is_invalid() {
		ApiKeyAppKeyNotValid error = assertThrows(ApiKeyAppKeyNotValid.class, () -> ApiKeyAppKey.create(""));
		assertThat(error.getMessage()).isEqualTo("AppKey is invalid");
	}

	@Test
	void it_should_throw_when_username_is_invalid() {
		ApiKeyUsernameNotValid error = assertThrows(ApiKeyUsernameNotValid.class, () -> ApiKeyUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
	}

	@Test
	void it_should_throw_when_active_is_invalid() {
		ApiKeyActiveNotValid error = assertThrows(ApiKeyActiveNotValid.class, () -> ApiKeyActive.create(null));
		assertThat(error.getMessage()).isEqualTo("Active is invalid");
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

	@Test
	void it_should_throw_when_tenant_is_invalid() {
		ApiKeyTenantNotValid error = assertThrows(ApiKeyTenantNotValid.class, () -> ApiKeyTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
	}

}
