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
public class ChatResponsesJson implements Serializable {

	private String responsesJson;

	public ChatResponsesJson(String responsesJson) {
		this.responsesJson = responsesJson;
	}

	public static ChatResponsesJson create(String responsesJson) {

		return new ChatResponsesJson(responsesJson);
	}

	public String value() {
		return this.responsesJson;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChatResponsesJson that)) return false;
		return this.responsesJson.equals(that.responsesJson);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(responsesJson);
	}

	@Override
	public String toString() {
		return String.valueOf(responsesJson);
	}
}
