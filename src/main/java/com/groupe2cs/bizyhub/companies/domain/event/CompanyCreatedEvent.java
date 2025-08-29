package com.groupe2cs.bizyhub.companies.domain.event;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCreatedEvent implements Serializable {

	private CompanyId id;
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
	private CompanySyncAt syncAt;
	private CompanyIsDefault isDefault;
	private CompanyCreatedBy createdBy;
	private CompanyTenant tenant;


}
