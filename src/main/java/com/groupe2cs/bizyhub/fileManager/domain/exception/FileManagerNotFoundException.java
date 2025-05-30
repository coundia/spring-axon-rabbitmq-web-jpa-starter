package com.groupe2cs.bizyhub.fileManager.domain.exception;

public class FileManagerNotFoundException extends RuntimeException {

	public FileManagerNotFoundException(String object, String value) {
		super("FileManager with " + object + ": '" + value + "' not found");
	}
}
