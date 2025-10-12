package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;

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
public class OrderIdentifiant implements Serializable {

	private String identifiant;

	public OrderIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public static OrderIdentifiant create(String identifiant) {

		return new OrderIdentifiant(identifiant);
	}

	public String value() {
		return this.identifiant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderIdentifiant that)) return false;
		return this.identifiant.equals(that.identifiant);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(identifiant);
	}

	@Override
	public String toString() {
		return String.valueOf(identifiant);
	}
}
