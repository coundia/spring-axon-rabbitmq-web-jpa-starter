package com.groupe2cs.bizyhub.customers.domain.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String object, String value) {
		super("Customer with " + object + ": '" + value + "' not found");
	}
}
