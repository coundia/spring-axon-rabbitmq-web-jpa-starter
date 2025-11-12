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
public class OrderDeliveryMethod implements Serializable {

	private String deliveryMethod;

	public OrderDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public static OrderDeliveryMethod create(String deliveryMethod) {

		return new OrderDeliveryMethod(deliveryMethod);
	}

	public String value() {
		return this.deliveryMethod;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderDeliveryMethod that)) return false;
		return this.deliveryMethod.equals(that.deliveryMethod);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(deliveryMethod);
	}

	@Override
	public String toString() {
		return String.valueOf(deliveryMethod);
	}
}
