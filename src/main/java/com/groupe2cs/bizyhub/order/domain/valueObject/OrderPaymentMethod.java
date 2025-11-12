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
public class OrderPaymentMethod implements Serializable {

	private String paymentMethod;

	public OrderPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public static OrderPaymentMethod create(String paymentMethod) {

		return new OrderPaymentMethod(paymentMethod);
	}

	public String value() {
		return this.paymentMethod;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderPaymentMethod that)) return false;
		return this.paymentMethod.equals(that.paymentMethod);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(paymentMethod);
	}

	@Override
	public String toString() {
		return String.valueOf(paymentMethod);
	}
}
