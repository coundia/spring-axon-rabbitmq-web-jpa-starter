package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreatedEvent implements Serializable {

	private TransactionId id;
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


}
