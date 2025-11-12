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
