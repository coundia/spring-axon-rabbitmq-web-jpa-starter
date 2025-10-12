package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotificationTitle implements Serializable {

	private String title;

	public NotificationTitle(String title) {
		this.title = title;
	}

	public static NotificationTitle create(String title) {

		if (title == null || title.isBlank()) {
			throw new NotificationTitleNotValid("Title is invalid");
		}
		return new NotificationTitle(title);
	}

	public String value() {
		return this.title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationTitle that)) return false;
		return this.title.equals(that.title);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(title);
	}

	@Override
	public String toString() {
		return String.valueOf(title);
	}
}
