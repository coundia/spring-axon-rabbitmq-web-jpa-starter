package com.groupe2cs.bizyhub.stock.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockMovementOrderLineId implements Serializable {

	private String orderLineId;

	public StockMovementOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	public static StockMovementOrderLineId create(String orderLineId) {

		return new StockMovementOrderLineId(orderLineId);
	}

	public String value() {
		return this.orderLineId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockMovementOrderLineId that)) return false;
		return this.orderLineId.equals(that.orderLineId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(orderLineId);
	}

	@Override
	public String toString() {
		return String.valueOf(orderLineId);
	}
}
