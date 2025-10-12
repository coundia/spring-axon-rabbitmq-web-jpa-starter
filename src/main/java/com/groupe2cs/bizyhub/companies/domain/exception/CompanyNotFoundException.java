package com.groupe2cs.bizyhub.companies.domain.exception;

import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;

public class CompanyNotFoundException extends RuntimeException {

	public CompanyNotFoundException(String object, String value) {
		super("Company with " + object + ": '" + value + "' not found");
	}
}
