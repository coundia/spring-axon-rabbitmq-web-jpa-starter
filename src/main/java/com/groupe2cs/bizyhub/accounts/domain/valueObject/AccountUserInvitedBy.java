package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountUserInvitedBy implements Serializable {

	private String invitedBy;

	public AccountUserInvitedBy(String invitedBy) {
		this.invitedBy = invitedBy;
	}

	public static AccountUserInvitedBy create(String invitedBy) {

		return new AccountUserInvitedBy(invitedBy);
	}

	public String value() {
		return this.invitedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserInvitedBy that)) return false;
		return this.invitedBy.equals(that.invitedBy);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(invitedBy);
	}

	@Override
	public String toString() {
		return String.valueOf(invitedBy);
	}
}
