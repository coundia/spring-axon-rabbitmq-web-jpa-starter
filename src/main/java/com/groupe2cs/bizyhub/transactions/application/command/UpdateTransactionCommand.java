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


}
