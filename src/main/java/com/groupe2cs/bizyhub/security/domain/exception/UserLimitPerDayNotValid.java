package com.groupe2cs.bizyhub.security.domain.exception;

public class UserLimitPerDayNotValid extends RuntimeException {
	public UserLimitPerDayNotValid(String message) {
		super(message);
	}
}
