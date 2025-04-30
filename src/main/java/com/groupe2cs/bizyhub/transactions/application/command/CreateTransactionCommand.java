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
	private TransactionAmount amount;
	private TransactionDateOperation dateOperation;
	private TransactionDescription description;
	private TransactionReference reference;
	private TransactionIsRecurring isRecurring;
	private TransactionIsExcluToRapport isExcluToRapport;
	private TransactionStatus status;
	private TransactionBalance balance;
	private TransactionCategory category;
	private TransactionUpdatedAt updatedAt;
	private TransactionCreatedAt createdAt;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;

	public CreateTransactionCommand(

			TransactionAmount amount,
			TransactionDateOperation dateOperation,
			TransactionDescription description,
			TransactionReference reference,
			TransactionIsRecurring isRecurring,
			TransactionIsExcluToRapport isExcluToRapport,
			TransactionStatus status,
			TransactionBalance balance,
			TransactionCategory category,
			TransactionUpdatedAt updatedAt,
			TransactionCreatedAt createdAt,
			TransactionCreatedBy createdBy,
			TransactionTenant tenant
	) {
		this.id = TransactionId.create(UUID.randomUUID().toString());

		this.amount = amount;
		this.dateOperation = dateOperation;
		this.description = description;
		this.reference = reference;
		this.isRecurring = isRecurring;
		this.isExcluToRapport = isExcluToRapport;
		this.status = status;
		this.balance = balance;
		this.category = category;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
