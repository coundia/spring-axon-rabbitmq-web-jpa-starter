package com.groupe2cs.bizyhub.transactions.domain.exception;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;

public class TransactionNotFoundException extends RuntimeException {

	public TransactionNotFoundException(TransactionId id) {
		super("Transaction with ID " + id + " not found");
	}
}
