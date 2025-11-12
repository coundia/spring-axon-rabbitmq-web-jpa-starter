package com.groupe2cs.bizyhub.message.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class MessageDescription implements Serializable {

	private String description;

	public MessageDescription(String description) {
		this.description = description;
	}

	public static MessageDescription create(String description) {

		return new MessageDescription(description);
	}

	public String value() {
		return this.description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageDescription that)) return false;
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
