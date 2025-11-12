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
public class UserMessage implements Serializable {

	private String message;

	public UserMessage(String message) {
		this.message = message;
	}

	public static UserMessage create(String message) {

		return new UserMessage(message);
	}

	public String value() {
		return this.message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserMessage that)) return false;
		return this.message.equals(that.message);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(message);
	}

	@Override
	public String toString() {
		return String.valueOf(message);
	}
}
