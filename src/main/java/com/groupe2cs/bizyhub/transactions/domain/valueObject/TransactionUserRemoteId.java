package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionUserRemoteId implements Serializable {

	private String remoteId;

	public TransactionUserRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public static TransactionUserRemoteId create(String remoteId) {

		return new TransactionUserRemoteId(remoteId);
	}

	public String value() {
		return this.remoteId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserRemoteId that)) return false;
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
