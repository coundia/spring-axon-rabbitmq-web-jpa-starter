package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryRemoteIdNotValid;

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
public class CategoryRemoteId implements Serializable {

	private String remoteId;

	public CategoryRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public static CategoryRemoteId create(String remoteId) {

		return new CategoryRemoteId(remoteId);
	}

	public String value() {
		return this.remoteId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryRemoteId that)) return false;
		return this.remoteId.equals(that.remoteId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(remoteId);
	}

	@Override
	public String toString() {
		return String.valueOf(remoteId);
	}
}
