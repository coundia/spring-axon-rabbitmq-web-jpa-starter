package com.groupe2cs.bizyhub.companies.domain.exception;

public class CompanyNotFoundException extends RuntimeException {

	public CompanyNotFoundException(String object, String value) {
		super("Company with " + object + ": '" + value + "' not found");
	}
}
