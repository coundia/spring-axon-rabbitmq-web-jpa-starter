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
public class AccountUserRemoteId implements Serializable {

	private String remoteId;

	public AccountUserRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public static AccountUserRemoteId create(String remoteId) {

		return new AccountUserRemoteId(remoteId);
	}

	public String value() {
		return this.remoteId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserRemoteId that)) return false;
		return this.remoteId.equals(that.remoteId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(remoteId);
	}

	@Override
	public String toString() {
		return String.valueOf(remoteId);
	}
}
