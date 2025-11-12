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
public class MessageStatus implements Serializable {

	private String status;

	public MessageStatus(String status) {
		this.status = status;
	}

	public static MessageStatus create(String status) {

		return new MessageStatus(status);
	}

	public String value() {
		return this.status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageStatus that)) return false;
		return this.status.equals(that.status);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(status);
	}

	@Override
	public String toString() {
		return String.valueOf(status);
	}
}
