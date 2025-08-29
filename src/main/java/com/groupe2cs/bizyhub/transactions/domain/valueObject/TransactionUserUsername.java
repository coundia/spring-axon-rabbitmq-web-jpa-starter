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
public class TransactionUserUsername implements Serializable {

	private String username;

	public TransactionUserUsername(String username) {
		this.username = username;
	}

	public static TransactionUserUsername create(String username) {

		return new TransactionUserUsername(username);
	}

	public String value() {
		return this.username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserUsername that)) return false;
		return this.username.equals(that.username);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(username);
	}

	@Override
	public String toString() {
		return String.valueOf(username);
	}
}
