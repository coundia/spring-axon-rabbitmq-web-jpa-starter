package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionUserNotFoundException extends RuntimeException {

	public TransactionUserNotFoundException(String object, String value) {
		super("TransactionUser with " + object + ": '" + value + "' not found");
	}
}
