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
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCreatedByNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTenantNotValid;

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
public class CategoryTenant implements Serializable {

	private String tenant;

	public CategoryTenant(String tenant) {
		this.tenant = tenant;
	}

	public static CategoryTenant create(String tenant) {

		return new CategoryTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTenant that)) return false;
		return this.tenant.equals(that.tenant);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(tenant);
	}

	@Override
	public String toString() {
		return String.valueOf(tenant);
	}
}
