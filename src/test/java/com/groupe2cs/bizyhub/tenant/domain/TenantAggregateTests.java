package com.groupe2cs.bizyhub.tenant.domain;

import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.tenant.domain.exception.*;


public class TenantAggregateTests extends BaseUnitTests {

@Test
void it_should_create_tenant_with_valid_values() {
	TenantId id = TenantId.create(UUID.randomUUID().toString());
	TenantName name = TenantName.create(UUID.randomUUID().toString());
	TenantDescription description = TenantDescription.create(UUID.randomUUID().toString());
	TenantDomain domain = TenantDomain.create(UUID.randomUUID().toString());
	TenantLanguage language = TenantLanguage.create(UUID.randomUUID().toString());
	TenantActive active = TenantActive.create(true);
	TenantTenant tenant = TenantTenant.create(UUID.randomUUID().toString());
	TenantCreatedBy createdBy = TenantCreatedBy.create(UUID.randomUUID().toString());
	TenantAggregate aggregateTenantAggregate = new TenantAggregate(id, name, description, domain, language, active, tenant, createdBy);
	assertThat(aggregateTenantAggregate.getId()).isNotNull();
	assertThat(aggregateTenantAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTenantAggregate.getName()).isEqualTo(name);
	assertThat(aggregateTenantAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateTenantAggregate.getDomain()).isEqualTo(domain);
	assertThat(aggregateTenantAggregate.getLanguage()).isEqualTo(language);
	assertThat(aggregateTenantAggregate.getActive()).isEqualTo(active);
	assertThat(aggregateTenantAggregate.getTenant()).isEqualTo(tenant);
	assertThat(aggregateTenantAggregate.getCreatedBy()).isEqualTo(createdBy);
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
		TenantDescriptionNotValid error = assertThrows(TenantDescriptionNotValid.class, () -> TenantDescription.create(""));
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
		void it_should_throw_when_tenant_is_invalid() {
		TenantTenantNotValid error = assertThrows(TenantTenantNotValid.class, () -> TenantTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		TenantCreatedByNotValid error = assertThrows(TenantCreatedByNotValid.class, () -> TenantCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}

}
