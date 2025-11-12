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
public class OrderQuantity implements Serializable {

	private Integer quantity;

	public OrderQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static OrderQuantity create(Integer quantity) {

		return new OrderQuantity(quantity);
	}

	public Integer value() {
		return this.quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderQuantity that)) return false;
		return this.quantity.equals(that.quantity);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(quantity);
	}

	@Override
	public String toString() {
		return String.valueOf(quantity);
	}
}
