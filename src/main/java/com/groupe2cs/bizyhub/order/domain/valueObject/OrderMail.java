package com.groupe2cs.bizyhub.order.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderMail implements Serializable {

	private String mail;

	public OrderMail(String mail) {
		this.mail = mail;
	}

	public static OrderMail create(String mail) {

		return new OrderMail(mail);
	}

	public String value() {
		return this.mail;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderMail that)) return false;
		return this.mail.equals(that.mail);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(mail);
	}

	@Override
	public String toString() {
		return String.valueOf(mail);
	}
}
