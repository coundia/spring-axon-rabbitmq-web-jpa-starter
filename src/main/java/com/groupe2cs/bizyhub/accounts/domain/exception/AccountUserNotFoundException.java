package com.groupe2cs.bizyhub.accounts.domain.exception;

public class AccountUserNotFoundException extends RuntimeException {

	public AccountUserNotFoundException(String object, String value) {
		super("AccountUser with " + object + ": '" + value + "' not found");
	}
}
