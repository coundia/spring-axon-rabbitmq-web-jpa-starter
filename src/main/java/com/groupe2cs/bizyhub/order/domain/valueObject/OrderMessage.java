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
public class OrderMessage implements Serializable {

	private String message;

	public OrderMessage(String message) {
		this.message = message;
	}

	public static OrderMessage create(String message) {

		return new OrderMessage(message);
	}

	public String value() {
		return this.message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderMessage that)) return false;
		return this.message.equals(that.message);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(message);
	}

	@Override
	public String toString() {
		return String.valueOf(message);
	}
}
