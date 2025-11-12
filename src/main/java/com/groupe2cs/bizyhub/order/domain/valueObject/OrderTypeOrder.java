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
public class OrderTypeOrder implements Serializable {

	private String typeOrder;

	public OrderTypeOrder(String typeOrder) {
		this.typeOrder = typeOrder;
	}

	public static OrderTypeOrder create(String typeOrder) {

		return new OrderTypeOrder(typeOrder);
	}

	public String value() {
		return this.typeOrder;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderTypeOrder that)) return false;
		return this.typeOrder.equals(that.typeOrder);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeOrder);
	}

	@Override
	public String toString() {
		return String.valueOf(typeOrder);
	}
}
