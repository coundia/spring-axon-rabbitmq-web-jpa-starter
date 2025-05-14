package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionIsActiveNotValid extends RuntimeException {
	public TransactionIsActiveNotValid(String message) {
		super(message);
	}
}
