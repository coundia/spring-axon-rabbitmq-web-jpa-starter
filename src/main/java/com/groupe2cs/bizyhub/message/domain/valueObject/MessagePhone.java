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
public class MessagePhone implements Serializable {

	private String phone;

	public MessagePhone(String phone) {
		this.phone = phone;
	}

	public static MessagePhone create(String phone) {

		return new MessagePhone(phone);
	}

	public String value() {
		return this.phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessagePhone that)) return false;
		return this.phone.equals(that.phone);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(phone);
	}

	@Override
	public String toString() {
		return String.valueOf(phone);
	}
}
