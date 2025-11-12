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
public class MessageContent implements Serializable {

	private String content;

	public MessageContent(String content) {
		this.content = content;
	}

	public static MessageContent create(String content) {

		return new MessageContent(content);
	}

	public String value() {
		return this.content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageContent that)) return false;
		return this.content.equals(that.content);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(content);
	}

	@Override
	public String toString() {
		return String.valueOf(content);
	}
}
