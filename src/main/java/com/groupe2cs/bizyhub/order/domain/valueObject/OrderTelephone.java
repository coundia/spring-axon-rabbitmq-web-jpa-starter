package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTelephoneNotValid;

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
public class OrderTelephone implements Serializable {

	private String telephone;

	public OrderTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static OrderTelephone create(String telephone) {

		return new OrderTelephone(telephone);
	}

	public String value() {
		return this.telephone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderTelephone that)) return false;
		return this.telephone.equals(that.telephone);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(telephone);
	}

	@Override
	public String toString() {
		return String.valueOf(telephone);
	}
}
