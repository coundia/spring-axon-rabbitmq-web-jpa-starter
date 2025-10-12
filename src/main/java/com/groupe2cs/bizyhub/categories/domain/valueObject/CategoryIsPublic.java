package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryRemoteIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryLocalIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryAccountNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryStatusNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsPublicNotValid;

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
