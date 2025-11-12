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
public class OrderUserId implements Serializable {

	private String userId;

	public OrderUserId(String userId) {
		this.userId = userId;
	}

	public static OrderUserId create(String userId) {

		return new OrderUserId(userId);
	}

	public String value() {
		return this.userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderUserId that)) return false;
		return this.userId.equals(that.userId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(userId);
	}

	@Override
	public String toString() {
		return String.valueOf(userId);
	}
}
