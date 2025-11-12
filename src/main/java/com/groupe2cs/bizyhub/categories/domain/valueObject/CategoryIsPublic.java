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
public class CategoryIsPublic implements Serializable {

	private Boolean isPublic;

	public CategoryIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public static CategoryIsPublic create(Boolean isPublic) {

		return new CategoryIsPublic(isPublic);
	}

	public Boolean value() {
		return this.isPublic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryIsPublic that)) return false;
		return this.isPublic.equals(that.isPublic);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isPublic);
	}

	@Override
	public String toString() {
		return String.valueOf(isPublic);
	}
}
