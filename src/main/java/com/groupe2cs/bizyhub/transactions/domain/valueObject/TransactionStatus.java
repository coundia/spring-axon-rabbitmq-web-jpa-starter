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
public class TransactionStatus implements Serializable {

	private String status;

	public TransactionStatus(String status) {
		this.status = status;
	}

	public static TransactionStatus create(String status) {

		return new TransactionStatus(status);
	}

	public String value() {
		return this.status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionStatus that)) return false;
		return this.status.equals(that.status);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(status);
	}

	@Override
	public String toString() {
		return String.valueOf(status);
	}
}
