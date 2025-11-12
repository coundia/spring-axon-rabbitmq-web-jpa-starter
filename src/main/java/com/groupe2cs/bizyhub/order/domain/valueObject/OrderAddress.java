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
public class OrderAddress implements Serializable {

	private String address;

	public OrderAddress(String address) {
		this.address = address;
	}

	public static OrderAddress create(String address) {

		return new OrderAddress(address);
	}

	public String value() {
		return this.address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderAddress that)) return false;
		return this.address.equals(that.address);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(address);
	}

	@Override
	public String toString() {
		return String.valueOf(address);
	}
}
