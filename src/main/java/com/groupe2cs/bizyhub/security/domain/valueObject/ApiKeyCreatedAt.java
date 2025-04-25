package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedAtNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiKeyCreatedAt implements Serializable {

	private java.time.Instant createdAt;

	public ApiKeyCreatedAt(java.time.Instant createdAt) {
		this.createdAt = createdAt;
	}

	public static ApiKeyCreatedAt create(java.time.Instant createdAt) {
		if (createdAt == null) {
			throw new ApiKeyCreatedAtNotValid("CreatedAt is invalid");
		}
		return new ApiKeyCreatedAt(createdAt);
	}

	public java.time.Instant value() {
		return this.createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ApiKeyCreatedAt that)) return false;
		return this.createdAt.equals(that.createdAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(createdAt);
	}

	@Override
	public String toString() {
		return String.valueOf(createdAt);
	}
}
