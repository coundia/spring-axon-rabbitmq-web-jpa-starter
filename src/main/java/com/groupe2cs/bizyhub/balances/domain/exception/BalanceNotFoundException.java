package com.groupe2cs.bizyhub.balances.domain.exception;

public class BalanceNotFoundException extends RuntimeException {

	public BalanceNotFoundException(String object, String value) {
		super("Balance with " + object + ": '" + value + "' not found");
	}
}
