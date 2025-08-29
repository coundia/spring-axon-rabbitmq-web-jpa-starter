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
public class NotificationAccount implements Serializable {

	private String account;

	public NotificationAccount(String account) {
		this.account = account;
	}

	public static NotificationAccount create(String account) {

		return new NotificationAccount(account);
	}

	public String value() {
		return this.account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationAccount that)) return false;
		return this.account.equals(that.account);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(account);
	}

	@Override
	public String toString() {
		return String.valueOf(account);
	}
}
