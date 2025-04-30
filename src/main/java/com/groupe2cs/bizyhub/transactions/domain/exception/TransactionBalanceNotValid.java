package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionBalanceNotValid extends RuntimeException {
	public TransactionBalanceNotValid(String message) {
		super(message);
	}
}
