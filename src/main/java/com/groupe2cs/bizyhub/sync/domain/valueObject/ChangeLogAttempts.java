package com.groupe2cs.bizyhub.sync.domain.valueObject;

import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAttemptsNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChangeLogAttempts implements Serializable {

	private Integer attempts;

	public ChangeLogAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public static ChangeLogAttempts create(Integer attempts) {

		if (attempts < 0) {
			throw new ChangeLogAttemptsNotValid("Attempts is invalid");
		}
		return new ChangeLogAttempts(attempts);
	}

	public Integer value() {
		return this.attempts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChangeLogAttempts that)) return false;
		return this.attempts.equals(that.attempts);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(attempts);
	}

	@Override
	public String toString() {
		return String.valueOf(attempts);
	}
}
