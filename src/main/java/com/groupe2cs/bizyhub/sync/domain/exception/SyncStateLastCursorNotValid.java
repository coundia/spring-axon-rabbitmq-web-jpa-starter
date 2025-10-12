package com.groupe2cs.bizyhub.sync.domain.exception;

public class SyncStateLastCursorNotValid extends RuntimeException {
	public SyncStateLastCursorNotValid(String message) {
		super(message);
	}
}
