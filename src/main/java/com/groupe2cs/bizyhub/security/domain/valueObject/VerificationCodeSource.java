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
public class VerificationCodeSource implements Serializable {

	private String source;

	public VerificationCodeSource(String source) {
		this.source = source;
	}

	public static VerificationCodeSource create(String source) {

		return new VerificationCodeSource(source);
	}

	public String value() {
		return this.source;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VerificationCodeSource that)) return false;
		return this.source.equals(that.source);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(source);
	}

	@Override
	public String toString() {
		return String.valueOf(source);
	}
}
