package com.groupe2cs.bizyhub.categories.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryVersion implements Serializable {

	private Integer version;

	public CategoryVersion(Integer version) {
		this.version = version;
	}

	public static CategoryVersion create(Integer version) {

		return new CategoryVersion(version);
	}

	public Integer value() {
		return this.version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryVersion that)) return false;
		return this.version.equals(that.version);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(version);
	}

	@Override
	public String toString() {
		return String.valueOf(version);
	}
}
