package com.groupe2cs.bizyhub.message.domain.exception;

public class MessageNotFoundException extends RuntimeException {

	public MessageNotFoundException(String object, String value) {
		super("Message with " + object + ": '" + value + "' not found");
	}
}
