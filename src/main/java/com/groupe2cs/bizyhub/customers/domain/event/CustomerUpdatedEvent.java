package com.groupe2cs.bizyhub.customers.domain.event;

	import com.groupe2cs.bizyhub.customers.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdatedEvent implements Serializable {

	private CustomerId id;
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



}
