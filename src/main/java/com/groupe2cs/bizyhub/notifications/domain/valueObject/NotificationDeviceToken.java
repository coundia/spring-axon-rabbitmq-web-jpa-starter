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
public class NotificationDeviceToken implements Serializable {

	private String deviceToken;

	public NotificationDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public static NotificationDeviceToken create(String deviceToken) {

		return new NotificationDeviceToken(deviceToken);
	}

	public String value() {
		return this.deviceToken;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationDeviceToken that)) return false;
		return this.deviceToken.equals(that.deviceToken);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(deviceToken);
	}

	@Override
	public String toString() {
		return String.valueOf(deviceToken);
	}
}
