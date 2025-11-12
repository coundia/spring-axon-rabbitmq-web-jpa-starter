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
