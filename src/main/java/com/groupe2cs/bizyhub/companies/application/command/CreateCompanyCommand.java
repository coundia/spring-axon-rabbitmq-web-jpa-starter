package com.groupe2cs.bizyhub.companies.application.command;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompanyCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private CompanyId id = CompanyId.create(UUID.randomUUID().toString());
	private CompanyRemoteId remoteId;
	private CompanyLocalId localId;
	private CompanyCode code;
	private CompanyName name;
	private CompanyDescription description;
	private CompanyPhone phone;
	private CompanyEmail email;
	private CompanyWebsite website;
	private CompanyTaxId taxId;
	private CompanyCurrency currency;
	private CompanyAddressLine1 addressLine1;
	private CompanyAddressLine2 addressLine2;
	private CompanyCity city;
	private CompanyRegion region;
	private CompanyCountry country;
	private CompanyAccount account;
	private CompanyPostalCode postalCode;
	private CompanyIsActive isActive;
	private CompanyStatus status;
	private CompanyIsPublic isPublic;
	private CompanySyncAt syncAt;
	private CompanyIsDefault isDefault;
	private CompanyCreatedBy createdBy;
	private CompanyTenant tenant;

	public CreateCompanyCommand(

			CompanyRemoteId remoteId,
			CompanyLocalId localId,
			CompanyCode code,
			CompanyName name,
			CompanyDescription description,
			CompanyPhone phone,
			CompanyEmail email,
			CompanyWebsite website,
			CompanyTaxId taxId,
			CompanyCurrency currency,
			CompanyAddressLine1 addressLine1,
			CompanyAddressLine2 addressLine2,
			CompanyCity city,
			CompanyRegion region,
			CompanyCountry country,
			CompanyAccount account,
			CompanyPostalCode postalCode,
			CompanyIsActive isActive,
			CompanyStatus status,
			CompanyIsPublic isPublic,
			CompanySyncAt syncAt,
			CompanyIsDefault isDefault,
			CompanyCreatedBy createdBy,
			CompanyTenant tenant
	) {
		this.id = CompanyId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.phone = phone;
		this.email = email;
		this.website = website;
		this.taxId = taxId;
		this.currency = currency;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.region = region;
		this.country = country;
		this.account = account;
		this.postalCode = postalCode;
		this.isActive = isActive;
		this.status = status;
		this.isPublic = isPublic;
		this.syncAt = syncAt;
		this.isDefault = isDefault;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
