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
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDescriptionNotValid;

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
public class CategoryDescription implements Serializable {

	private String description;

	public CategoryDescription(String description) {
		this.description = description;
	}

	public static CategoryDescription create(String description) {

		return new CategoryDescription(description);
	}

	public String value() {
		return this.description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryDescription that)) return false;
		return this.description.equals(that.description);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(description);
	}

	@Override
	public String toString() {
		return String.valueOf(description);
	}
}
