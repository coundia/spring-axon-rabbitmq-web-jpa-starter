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
public class NotificationErrorMessage implements Serializable {

	private String errorMessage;

	public NotificationErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static NotificationErrorMessage create(String errorMessage) {

		return new NotificationErrorMessage(errorMessage);
	}

	public String value() {
		return this.errorMessage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationErrorMessage that)) return false;
		return this.errorMessage.equals(that.errorMessage);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(errorMessage);
	}

	@Override
	public String toString() {
		return String.valueOf(errorMessage);
	}
}
