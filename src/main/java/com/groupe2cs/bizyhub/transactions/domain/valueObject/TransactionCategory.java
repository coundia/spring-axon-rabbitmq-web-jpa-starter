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
public class TransactionCategory implements Serializable {

	private String category;

	public TransactionCategory(String category) {
		this.category = category;
	}

	public static TransactionCategory create(String category) {

		return new TransactionCategory(category);
	}

	public String value() {
		return this.category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionCategory that)) return false;
		return this.category.equals(that.category);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(category);
	}

	@Override
	public String toString() {
		return String.valueOf(category);
	}
}
