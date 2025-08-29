package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotificationMessage implements Serializable {

	private String message;

	public NotificationMessage(String message) {
		this.message = message;
	}

	public static NotificationMessage create(String message) {

		return new NotificationMessage(message);
	}

	public String value() {
		return this.message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationMessage that)) return false;
		return this.message.equals(that.message);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(message);
	}

	@Override
	public String toString() {
		return String.valueOf(message);
	}
}
