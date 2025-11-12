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
public class OrderVille implements Serializable {

	private String ville;

	public OrderVille(String ville) {
		this.ville = ville;
	}

	public static OrderVille create(String ville) {

		return new OrderVille(ville);
	}

	public String value() {
		return this.ville;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderVille that)) return false;
		return this.ville.equals(that.ville);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(ville);
	}

	@Override
	public String toString() {
		return String.valueOf(ville);
	}
}
