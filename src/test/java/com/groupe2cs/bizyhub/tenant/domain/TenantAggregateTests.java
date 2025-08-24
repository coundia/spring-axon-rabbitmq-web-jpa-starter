package com.groupe2cs.bizyhub.tenant.domain;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class TenantAggregateTests extends BaseUnitTests {

@Test
void it_should_create_tenant_with_valid_values() {
	TenantId id = TenantId.create(UUID.randomUUID().toString());
	TenantName name = TenantName.create(UUID.randomUUID().toString());
	TenantDescription description = TenantDescription.create(UUID.randomUUID().toString());
	TenantDomain domain = TenantDomain.create(UUID.randomUUID().toString());
	TenantLanguage language = TenantLanguage.create(UUID.randomUUID().toString());
	TenantActive active = TenantActive.create(false);
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

}
