package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionUserIsActiveNotValid extends RuntimeException {
	public TransactionUserIsActiveNotValid(String message) {
		super(message);
	}
}
