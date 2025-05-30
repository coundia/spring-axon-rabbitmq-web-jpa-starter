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
	private TransactionName name;
	private TransactionAmount amount;
	private TransactionDetails details;
	private TransactionIsActive isActive;
	private TransactionAccount account;
	private TransactionCategory category;
	private TransactionTypeTransactionRaw typeTransactionRaw;
	private TransactionDateTransaction dateTransaction;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;

	public CreateTransactionCommand(

			TransactionName name,
			TransactionAmount amount,
			TransactionDetails details,
			TransactionIsActive isActive,
			TransactionAccount account,
			TransactionCategory category,
			TransactionTypeTransactionRaw typeTransactionRaw,
			TransactionDateTransaction dateTransaction,
			TransactionCreatedBy createdBy,
			TransactionTenant tenant
	) {
		this.id = TransactionId.create(UUID.randomUUID().toString());

		this.name = name;
		this.amount = amount;
		this.details = details;
		this.isActive = isActive;
		this.account = account;
		this.category = category;
		this.typeTransactionRaw = typeTransactionRaw;
		this.dateTransaction = dateTransaction;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
