package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionCreatedByNotValid extends RuntimeException {
	public TransactionCreatedByNotValid(String message) {
		super(message);
	}
}
