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
public class StockMovementDiscriminator implements Serializable {

	private String discriminator;

	public StockMovementDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public static StockMovementDiscriminator create(String discriminator) {

		return new StockMovementDiscriminator(discriminator);
	}

	public String value() {
		return this.discriminator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockMovementDiscriminator that)) return false;
		return this.discriminator.equals(that.discriminator);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(discriminator);
	}

	@Override
	public String toString() {
		return String.valueOf(discriminator);
	}
}
