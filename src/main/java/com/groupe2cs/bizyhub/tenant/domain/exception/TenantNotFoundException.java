package com.groupe2cs.bizyhub.tenant.domain.exception;

public class TenantNotFoundException extends RuntimeException {

	public TenantNotFoundException(String object, String value) {
		super("Tenant with " + object + ": '" + value + "' not found");
	}
}
