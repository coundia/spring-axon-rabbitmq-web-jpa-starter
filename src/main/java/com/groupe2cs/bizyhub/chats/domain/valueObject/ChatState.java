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
public class ChatState implements Serializable {

	private String state;

	public ChatState(String state) {
		this.state = state;
	}

	public static ChatState create(String state) {

		return new ChatState(state);
	}

	public String value() {
		return this.state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChatState that)) return false;
		return this.state.equals(that.state);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(state);
	}

	@Override
	public String toString() {
		return String.valueOf(state);
	}
}
