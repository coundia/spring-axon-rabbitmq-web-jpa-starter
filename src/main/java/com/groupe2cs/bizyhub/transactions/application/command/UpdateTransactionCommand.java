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
	private TransactionName name;
	private TransactionAmount amount;
	private TransactionDetails details;
	private TransactionIsActive isActive;
	private TransactionAccount account;
	private TransactionCategory category;
	private TransactionTypeTransactionRaw typeTransactionRaw;
	private TransactionDateTransaction dateTransaction;
	private TransactionUpdatedAt updatedAt;
	private TransactionReference reference;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;


}
