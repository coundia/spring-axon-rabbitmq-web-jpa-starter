package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTelephoneNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMailNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderVilleNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderRemoteIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderLocalIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderStatusNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderBuyerNameNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderAddressNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderNotesNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMessageNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTypeOrderNotValid;

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
