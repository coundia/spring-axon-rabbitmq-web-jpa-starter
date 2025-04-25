package com.groupe2cs.bizyhub.tenant.domain;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.tenant.domain.exception.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TenantAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_tenant_with_valid_values() {
		TenantId id = TenantId.create(UUID.randomUUID().toString());
		TenantName name = TenantName.create(UUID.randomUUID().toString());
		TenantDescription description = TenantDescription.create(UUID.randomUUID().toString());
		TenantDomain domain = TenantDomain.create(UUID.randomUUID().toString());
		TenantLanguage language = TenantLanguage.create(UUID.randomUUID().toString());
		TenantActive active = TenantActive.create(true);
		TenantCreatedBy createdBy = TenantCreatedBy.create(UUID.randomUUID().toString());
		TenantAggregate tenant = new TenantAggregate(id, name, description, domain, language, active, createdBy);
		assertThat(tenant.getId()).isNotNull();
		assertThat(tenant.getId()).isEqualTo(id);
		assertThat(tenant.getName()).isEqualTo(name);
		assertThat(tenant.getDescription()).isEqualTo(description);
		assertThat(tenant.getDomain()).isEqualTo(domain);
		assertThat(tenant.getLanguage()).isEqualTo(language);
		assertThat(tenant.getActive()).isEqualTo(active);
		assertThat(tenant.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		TenantIdNotValid error = assertThrows(TenantIdNotValid.class, () -> TenantId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_name_is_invalid() {
		TenantNameNotValid error = assertThrows(TenantNameNotValid.class, () -> TenantName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
	}

	@Test
	void it_should_throw_when_description_is_invalid() {
		TenantDescriptionNotValid
				error =
				assertThrows(TenantDescriptionNotValid.class, () -> TenantDescription.create(""));
		assertThat(error.getMessage()).isEqualTo("Description is invalid");
	}

	@Test
	void it_should_throw_when_domain_is_invalid() {
		TenantDomainNotValid error = assertThrows(TenantDomainNotValid.class, () -> TenantDomain.create(""));
		assertThat(error.getMessage()).isEqualTo("Domain is invalid");
	}

	@Test
	void it_should_throw_when_language_is_invalid() {
		TenantLanguageNotValid error = assertThrows(TenantLanguageNotValid.class, () -> TenantLanguage.create(""));
		assertThat(error.getMessage()).isEqualTo("Language is invalid");
	}

	@Test
	void it_should_throw_when_active_is_invalid() {
		TenantActiveNotValid error = assertThrows(TenantActiveNotValid.class, () -> TenantActive.create(null));
		assertThat(error.getMessage()).isEqualTo("Active is invalid");
	}

	@Test
	void it_should_throw_when_createdBy_is_invalid() {
		TenantCreatedByNotValid error = assertThrows(TenantCreatedByNotValid.class, () -> TenantCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
	}

}
