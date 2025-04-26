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
	private TransactionReference reference;
	private TransactionAmount amount;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;


}
