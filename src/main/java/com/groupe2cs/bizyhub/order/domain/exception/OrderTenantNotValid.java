package com.groupe2cs.bizyhub.order.domain.exception;

public class OrderTenantNotValid extends RuntimeException {
	public OrderTenantNotValid(String message) {
		super(message);
	}
}
