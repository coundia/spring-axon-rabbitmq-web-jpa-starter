package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionIsRecurringNotValid extends RuntimeException {
	public TransactionIsRecurringNotValid(String message) {
		super(message);
	}
}
