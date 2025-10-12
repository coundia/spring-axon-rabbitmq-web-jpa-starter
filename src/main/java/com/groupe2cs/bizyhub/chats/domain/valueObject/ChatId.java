package com.groupe2cs.bizyhub.chats.domain.valueObject;

import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatId implements Serializable {

	private String id;

	public ChatId(String id) {
		this.id = id;
	}

	public static ChatId create(String id) {

		if (id == null || id.isBlank()) {
			throw new ChatIdNotValid("Id is invalid");
		}
		return new ChatId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChatId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
