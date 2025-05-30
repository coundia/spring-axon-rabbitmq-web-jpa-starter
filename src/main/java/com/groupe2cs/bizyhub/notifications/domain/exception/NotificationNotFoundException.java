package com.groupe2cs.bizyhub.notifications.domain.exception;

public class NotificationNotFoundException extends RuntimeException {

	public NotificationNotFoundException(String object, String value) {
		super("Notification with " + object + ": '" + value + "' not found");
	}
}
