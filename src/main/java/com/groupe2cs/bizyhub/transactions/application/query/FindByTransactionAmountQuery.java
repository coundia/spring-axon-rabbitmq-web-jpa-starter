package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;

public class FindByTransactionAmountQuery {

	private final TransactionAmount amount;

	public FindByTransactionAmountQuery(TransactionAmount amount) {
		this.amount = amount;
	}

	public TransactionAmount getAmount() {
		return amount;
	}
}
