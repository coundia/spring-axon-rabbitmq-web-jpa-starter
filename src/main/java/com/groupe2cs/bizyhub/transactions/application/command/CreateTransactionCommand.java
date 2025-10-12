package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private TransactionId id = TransactionId.create(UUID.randomUUID().toString());
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

	public CreateTransactionCommand(

			TransactionRemoteId remoteId,
			TransactionLocalId localId,
			TransactionCode code,
			TransactionDescription description,
			TransactionAmount amount,
			TransactionTypeEntry typeEntry,
			TransactionDateTransaction dateTransaction,
			TransactionStatus status,
			TransactionEntityName entityName,
			TransactionEntityId entityId,
			TransactionAccount account,
			TransactionSyncAt syncAt,
			TransactionCategory category,
			TransactionCompany company,
			TransactionCustomer customer,
			TransactionDebt debt,
			TransactionCreatedBy createdBy,
			TransactionTenant tenant
	) {
		this.id = TransactionId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.code = code;
		this.description = description;
		this.amount = amount;
		this.typeEntry = typeEntry;
		this.dateTransaction = dateTransaction;
		this.status = status;
		this.entityName = entityName;
		this.entityId = entityId;
		this.account = account;
		this.syncAt = syncAt;
		this.category = category;
		this.company = company;
		this.customer = customer;
		this.debt = debt;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
