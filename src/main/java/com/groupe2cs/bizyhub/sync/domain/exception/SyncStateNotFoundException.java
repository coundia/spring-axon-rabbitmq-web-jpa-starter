package com.groupe2cs.bizyhub.sync.domain.exception;

public class SyncStateNotFoundException extends RuntimeException {

	public SyncStateNotFoundException(String object, String value) {
		super("SyncState with " + object + ": '" + value + "' not found");
	}
}
