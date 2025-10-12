package com.groupe2cs.bizyhub.companies.domain;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.domain.exception.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;


public class CompanyAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_company_with_valid_values() {
		CompanyId id = CompanyId.create(UUID.randomUUID().toString());
		CompanyRemoteId remoteId = CompanyRemoteId.create(UUID.randomUUID().toString());
		CompanyLocalId localId = CompanyLocalId.create(UUID.randomUUID().toString());
		CompanyCode code = CompanyCode.create(UUID.randomUUID().toString());
		CompanyName name = CompanyName.create(UUID.randomUUID().toString());
		CompanyDescription description = CompanyDescription.create(UUID.randomUUID().toString());
		CompanyPhone phone = CompanyPhone.create(UUID.randomUUID().toString());
		CompanyEmail email = CompanyEmail.create(UUID.randomUUID().toString());
		CompanyWebsite website = CompanyWebsite.create(UUID.randomUUID().toString());
		CompanyTaxId taxId = CompanyTaxId.create(UUID.randomUUID().toString());
		CompanyCurrency currency = CompanyCurrency.create(UUID.randomUUID().toString());
		CompanyAddressLine1 addressLine1 = CompanyAddressLine1.create(UUID.randomUUID().toString());
		CompanyAddressLine2 addressLine2 = CompanyAddressLine2.create(UUID.randomUUID().toString());
		CompanyCity city = CompanyCity.create(UUID.randomUUID().toString());
		CompanyRegion region = CompanyRegion.create(UUID.randomUUID().toString());
		CompanyCountry country = CompanyCountry.create(UUID.randomUUID().toString());
		CompanyAccount account = CompanyAccount.create(UUID.randomUUID().toString());
		CompanyPostalCode postalCode = CompanyPostalCode.create(UUID.randomUUID().toString());
		CompanyIsActive isActive = CompanyIsActive.create(true);
		CompanyStatus status = CompanyStatus.create(UUID.randomUUID().toString());
		CompanyIsPublic isPublic = CompanyIsPublic.create(true);
		CompanySyncAt syncAt = CompanySyncAt.create(java.time.Instant.now().plusSeconds(3600));
		CompanyIsDefault isDefault = CompanyIsDefault.create(true);
		CompanyCreatedBy createdBy = CompanyCreatedBy.create(UUID.randomUUID().toString());
		CompanyTenant tenant = CompanyTenant.create(UUID.randomUUID().toString());
		CompanyAggregate
				aggregateCompanyAggregate =
				new CompanyAggregate(id,
						remoteId,
						localId,
						code,
						name,
						description,
						phone,
						email,
						website,
						taxId,
						currency,
						addressLine1,
						addressLine2,
						city,
						region,
						country,
						account,
						postalCode,
						isActive,
						status,
						isPublic,
						syncAt,
						isDefault,
						createdBy,
						tenant);
		assertThat(aggregateCompanyAggregate.getId()).isNotNull();
		assertThat(aggregateCompanyAggregate.getId()).isEqualTo(id);
		assertThat(aggregateCompanyAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateCompanyAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateCompanyAggregate.getCode()).isEqualTo(code);
		assertThat(aggregateCompanyAggregate.getName()).isEqualTo(name);
		assertThat(aggregateCompanyAggregate.getDescription()).isEqualTo(description);
		assertThat(aggregateCompanyAggregate.getPhone()).isEqualTo(phone);
		assertThat(aggregateCompanyAggregate.getEmail()).isEqualTo(email);
		assertThat(aggregateCompanyAggregate.getWebsite()).isEqualTo(website);
		assertThat(aggregateCompanyAggregate.getTaxId()).isEqualTo(taxId);
		assertThat(aggregateCompanyAggregate.getCurrency()).isEqualTo(currency);
		assertThat(aggregateCompanyAggregate.getAddressLine1()).isEqualTo(addressLine1);
		assertThat(aggregateCompanyAggregate.getAddressLine2()).isEqualTo(addressLine2);
		assertThat(aggregateCompanyAggregate.getCity()).isEqualTo(city);
		assertThat(aggregateCompanyAggregate.getRegion()).isEqualTo(region);
		assertThat(aggregateCompanyAggregate.getCountry()).isEqualTo(country);
		assertThat(aggregateCompanyAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateCompanyAggregate.getPostalCode()).isEqualTo(postalCode);
		assertThat(aggregateCompanyAggregate.getIsActive()).isEqualTo(isActive);
		assertThat(aggregateCompanyAggregate.getStatus()).isEqualTo(status);
		assertThat(aggregateCompanyAggregate.getIsPublic()).isEqualTo(isPublic);
		assertThat(aggregateCompanyAggregate.getSyncAt()).isEqualTo(syncAt);
		assertThat(aggregateCompanyAggregate.getIsDefault()).isEqualTo(isDefault);
		assertThat(aggregateCompanyAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateCompanyAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		CompanyIdNotValid error = assertThrows(CompanyIdNotValid.class, () -> CompanyId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_code_is_invalid() {
		CompanyCodeNotValid error = assertThrows(CompanyCodeNotValid.class, () -> CompanyCode.create(""));
		assertThat(error.getMessage()).isEqualTo("Code is invalid");
	}

	@Test
	void it_should_throw_when_isDefault_is_invalid() {
		CompanyIsDefaultNotValid
				error =
				assertThrows(CompanyIsDefaultNotValid.class, () -> CompanyIsDefault.create(null));
		assertThat(error.getMessage()).isEqualTo("IsDefault is invalid");
	}

}
