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
public class MessagePlateforme implements Serializable {

	private String plateforme;

	public MessagePlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public static MessagePlateforme create(String plateforme) {

		return new MessagePlateforme(plateforme);
	}

	public String value() {
		return this.plateforme;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessagePlateforme that)) return false;
		return this.plateforme.equals(that.plateforme);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(plateforme);
	}

	@Override
	public String toString() {
		return String.valueOf(plateforme);
	}
}
