package com.groupe2cs.bizyhub.sync.domain.exception;

public class ChangeLogNotFoundException extends RuntimeException {

	public ChangeLogNotFoundException(String object, String value) {
		super("ChangeLog with " + object + ": '" + value + "' not found");
	}
}
