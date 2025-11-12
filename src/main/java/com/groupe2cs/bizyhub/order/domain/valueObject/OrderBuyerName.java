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
public class OrderBuyerName implements Serializable {

	private String buyerName;

	public OrderBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public static OrderBuyerName create(String buyerName) {

		return new OrderBuyerName(buyerName);
	}

	public String value() {
		return this.buyerName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderBuyerName that)) return false;
		return this.buyerName.equals(that.buyerName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(buyerName);
	}

	@Override
	public String toString() {
		return String.valueOf(buyerName);
	}
}
