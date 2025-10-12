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
public class ChatDateTransaction implements Serializable {

	private java.time.Instant dateTransaction;

	public ChatDateTransaction(java.time.Instant dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public static ChatDateTransaction create(java.time.Instant dateTransaction) {

		return new ChatDateTransaction(dateTransaction);
	}

	public java.time.Instant value() {
		return this.dateTransaction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChatDateTransaction that)) return false;
		return this.dateTransaction.equals(that.dateTransaction);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(dateTransaction);
	}

	@Override
	public String toString() {
		return String.valueOf(dateTransaction);
	}
}
