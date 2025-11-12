package com.groupe2cs.bizyhub.order.domain.valueObject;

import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderId implements Serializable {

	private String id;

	public OrderId(String id) {
		this.id = id;
	}

	public static OrderId create(String id) {

		if (id == null || id.isBlank()) {
			throw new OrderIdNotValid("Id is invalid");
		}
		return new OrderId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
