package com.groupe2cs.bizyhub.security.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class VerificationCodeToken implements Serializable {

	private String token;

	public VerificationCodeToken(String token) {
		this.token = token;
	}

	public static VerificationCodeToken create(String token) {

		return new VerificationCodeToken(token);
	}

	public String value() {
		return this.token;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VerificationCodeToken that)) return false;
		return this.token.equals(that.token);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(token);
	}

	@Override
	public String toString() {
		return String.valueOf(token);
	}
}
