package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceActivateNotificationNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceActivateNotification implements Serializable {

	private Boolean activateNotification;

	public BalanceActivateNotification(Boolean activateNotification) {
		this.activateNotification = activateNotification;
	}

	public static BalanceActivateNotification create(Boolean activateNotification) {
		if (activateNotification == null) {
			throw new BalanceActivateNotificationNotValid("ActivateNotification is invalid");
		}
		return new BalanceActivateNotification(activateNotification);
	}

	public Boolean value() {
		return this.activateNotification;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceActivateNotification that)) return false;
		return this.activateNotification.equals(that.activateNotification);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(activateNotification);
	}

	@Override
	public String toString() {
		return String.valueOf(activateNotification);
	}
}
