package com.groupe2cs.bizyhub.transactions.domain.event;

	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

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
public class TransactionEntryCreatedEvent implements Serializable {

	private TransactionEntryId id;
	private TransactionEntryRemoteId remoteId;
	private TransactionEntryLocalId localId;
	private TransactionEntryCode code;
	private TransactionEntryDescription description;
	private TransactionEntryAmount amount;
	private TransactionEntryTypeEntry typeEntry;
	private TransactionEntryDateTransaction dateTransaction;
	private TransactionEntryStatus status;
	private TransactionEntryEntityName entityName;
	private TransactionEntryEntityId entityId;
	private TransactionEntryAccount account;
	private TransactionEntrySyncAt syncAt;
	private TransactionEntryCategory category;
	private TransactionEntryCompany company;
	private TransactionEntryCustomer customer;
	private TransactionEntryDebt debt;
	private TransactionEntryCreatedBy createdBy;
	private TransactionEntryTenant tenant;



}
