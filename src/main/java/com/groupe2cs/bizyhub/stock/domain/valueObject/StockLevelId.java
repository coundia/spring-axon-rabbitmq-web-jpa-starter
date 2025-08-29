package com.groupe2cs.bizyhub.stock.domain.valueObject;

import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockLevelId implements Serializable {

	private String id;

	public StockLevelId(String id) {
		this.id = id;
	}

	public static StockLevelId create(String id) {

		if (id == null || id.isBlank()) {
			throw new StockLevelIdNotValid("Id is invalid");
		}
		return new StockLevelId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockLevelId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
