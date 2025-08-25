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
public class TransactionUpdatedEvent implements Serializable {

	private TransactionId id;
	private TransactionRemoteId remoteId;
	private TransactionLocalId localId;
	private TransactionCode code;
	private TransactionDescription description;
	private TransactionAmount amount;
	private TransactionTypeEntry typeEntry;
	private TransactionDateTransaction dateTransaction;
	private TransactionStatus status;
	private TransactionEntityName entityName;
	private TransactionEntityId entityId;
	private TransactionAccount account;
	private TransactionSyncAt syncAt;
	private TransactionCategory category;
	private TransactionCompany company;
	private TransactionCustomer customer;
	private TransactionDebt debt;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;



}
