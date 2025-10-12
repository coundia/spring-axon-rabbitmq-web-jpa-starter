package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTransactionCommand implements Serializable {
	@TargetAggregateIdentifier
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
