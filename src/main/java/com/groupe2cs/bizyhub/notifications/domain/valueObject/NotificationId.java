package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotificationId implements Serializable {

	private String id;

	public NotificationId(String id) {
		this.id = id;
	}

	public static NotificationId create(String id) {

		if (id == null || id.isBlank()) {
			throw new NotificationIdNotValid("Id is invalid");
		}
		return new NotificationId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
