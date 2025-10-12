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
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeEntryNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryVersionNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategorySyncAtNotValid;

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
public class CategorySyncAt implements Serializable {

	private java.time.Instant syncAt;

	public CategorySyncAt(java.time.Instant syncAt) {
		this.syncAt = syncAt;
	}

	public static CategorySyncAt create(java.time.Instant syncAt) {

		return new CategorySyncAt(syncAt);
	}

	public java.time.Instant value() {
		return this.syncAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategorySyncAt that)) return false;
		return this.syncAt.equals(that.syncAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(syncAt);
	}

	@Override
	public String toString() {
		return String.valueOf(syncAt);
	}
}
