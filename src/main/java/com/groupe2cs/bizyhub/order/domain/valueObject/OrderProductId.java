package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderProductId implements Serializable {

	private String productId;

	public OrderProductId(String productId) {
		this.productId = productId;
	}

	public static OrderProductId create(String productId) {

		return new OrderProductId(productId);
	}

	public String value() {
		return this.productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderProductId that)) return false;
		return this.productId.equals(that.productId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(productId);
	}

	@Override
	public String toString() {
		return String.valueOf(productId);
	}
}
