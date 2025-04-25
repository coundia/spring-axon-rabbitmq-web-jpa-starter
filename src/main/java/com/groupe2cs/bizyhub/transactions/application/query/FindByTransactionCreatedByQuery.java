package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionCreatedBy;

public class FindByTransactionCreatedByQuery {

	private final TransactionCreatedBy createdBy;

	public FindByTransactionCreatedByQuery(TransactionCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public TransactionCreatedBy getCreatedBy() {
		return createdBy;
	}
}
