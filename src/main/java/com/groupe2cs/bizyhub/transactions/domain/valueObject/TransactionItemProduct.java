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
public class TransactionItemProduct implements Serializable {

	private String product;

	public TransactionItemProduct(String product) {
		this.product = product;
	}

	public static TransactionItemProduct create(String product) {

		return new TransactionItemProduct(product);
	}

	public String value() {
		return this.product;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemProduct that)) return false;
		return this.product.equals(that.product);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(product);
	}

	@Override
	public String toString() {
		return String.valueOf(product);
	}
}
