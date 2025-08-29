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
public class CategoryTypeEntry implements Serializable {

	private String typeEntry;

	public CategoryTypeEntry(String typeEntry) {
		this.typeEntry = typeEntry;
	}

	public static CategoryTypeEntry create(String typeEntry) {

		return new CategoryTypeEntry(typeEntry);
	}

	public String value() {
		return this.typeEntry;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTypeEntry that)) return false;
		return this.typeEntry.equals(that.typeEntry);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeEntry);
	}

	@Override
	public String toString() {
		return String.valueOf(typeEntry);
	}
}
