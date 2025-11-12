package com.groupe2cs.bizyhub.order.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderAmountCents implements Serializable {

	private Double amountCents;

	public OrderAmountCents(Double amountCents) {
		this.amountCents = amountCents;
	}

	public static OrderAmountCents create(Double amountCents) {

		return new OrderAmountCents(amountCents);
	}

	public Double value() {
		return this.amountCents;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderAmountCents that)) return false;
		return this.amountCents.equals(that.amountCents);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(amountCents);
	}

	@Override
	public String toString() {
		return String.valueOf(amountCents);
	}
}
