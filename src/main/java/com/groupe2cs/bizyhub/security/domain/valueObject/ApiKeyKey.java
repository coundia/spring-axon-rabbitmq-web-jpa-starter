package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyKeyNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiKeyKey implements Serializable {

	private String key;

	public ApiKeyKey(String key) {
		this.key = key;
	}

	public static ApiKeyKey create(String key) {
		if (key == null || key.isBlank()) {
			throw new ApiKeyKeyNotValid("Key is invalid");
		}
		return new ApiKeyKey(key);
	}

	public String value() {
		return this.key;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ApiKeyKey that)) return false;
		return this.key.equals(that.key);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(key);
	}

	@Override
	public String toString() {
		return String.valueOf(key);
	}
}
