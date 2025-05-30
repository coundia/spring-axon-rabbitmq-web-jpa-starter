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
public class NotificationReserved implements Serializable {

	private String reserved;

	public NotificationReserved(String reserved) {
		this.reserved = reserved;
	}

	public static NotificationReserved create(String reserved) {

		return new NotificationReserved(reserved);
	}

	public String value() {
		return this.reserved;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationReserved that)) return false;
		return this.reserved.equals(that.reserved);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(reserved);
	}

	@Override
	public String toString() {
		return String.valueOf(reserved);
	}
}
