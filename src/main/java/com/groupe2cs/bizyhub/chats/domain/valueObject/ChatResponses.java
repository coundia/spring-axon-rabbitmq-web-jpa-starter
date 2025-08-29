package com.groupe2cs.bizyhub.chats.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatResponses implements Serializable {

	private String responses;

	public ChatResponses(String responses) {
		this.responses = responses;
	}

	public static ChatResponses create(String responses) {

		return new ChatResponses(responses);
	}

	public String value() {
		return this.responses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChatResponses that)) return false;
		return this.responses.equals(that.responses);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(responses);
	}

	@Override
	public String toString() {
		return String.valueOf(responses);
	}
}
