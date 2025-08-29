package com.groupe2cs.bizyhub.customers.application.command;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private CustomerId id = CustomerId.create(UUID.randomUUID().toString());
	private CustomerRemoteId remoteId;
	private CustomerLocalId localId;
	private CustomerCode code;
	private CustomerFirstName firstName;
	private CustomerLastName lastName;
	private CustomerFullName fullName;
	private CustomerBalance balance;
	private CustomerBalanceDebt balanceDebt;
	private CustomerPhone phone;
	private CustomerEmail email;
	private CustomerNotes notes;
	private CustomerStatus status;
	private CustomerAccount account;
	private CustomerCompany company;
	private CustomerAddressLine1 addressLine1;
	private CustomerAddressLine2 addressLine2;
	private CustomerCity city;
	private CustomerRegion region;
	private CustomerCountry country;
	private CustomerPostalCode postalCode;
	private CustomerSyncAt syncAt;
	private CustomerIsActive isActive;
	private CustomerCreatedBy createdBy;
	private CustomerTenant tenant;

	public CreateCustomerCommand(

			CustomerRemoteId remoteId,
			CustomerLocalId localId,
			CustomerCode code,
			CustomerFirstName firstName,
			CustomerLastName lastName,
			CustomerFullName fullName,
			CustomerBalance balance,
			CustomerBalanceDebt balanceDebt,
			CustomerPhone phone,
			CustomerEmail email,
			CustomerNotes notes,
			CustomerStatus status,
			CustomerAccount account,
			CustomerCompany company,
			CustomerAddressLine1 addressLine1,
			CustomerAddressLine2 addressLine2,
			CustomerCity city,
			CustomerRegion region,
			CustomerCountry country,
			CustomerPostalCode postalCode,
			CustomerSyncAt syncAt,
			CustomerIsActive isActive,
			CustomerCreatedBy createdBy,
			CustomerTenant tenant
	) {
		this.id = CustomerId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.balance = balance;
		this.balanceDebt = balanceDebt;
		this.phone = phone;
		this.email = email;
		this.notes = notes;
		this.status = status;
		this.account = account;
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.region = region;
		this.country = country;
		this.postalCode = postalCode;
		this.syncAt = syncAt;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
