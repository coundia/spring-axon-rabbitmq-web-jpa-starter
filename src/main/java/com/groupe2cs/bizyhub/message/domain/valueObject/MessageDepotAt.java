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
public class MessageDepotAt implements Serializable {

	private java.time.Instant depotAt;

	public MessageDepotAt(java.time.Instant depotAt) {
		this.depotAt = depotAt;
	}

	public static MessageDepotAt create(java.time.Instant depotAt) {

		return new MessageDepotAt(depotAt);
	}

	public java.time.Instant value() {
		return this.depotAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageDepotAt that)) return false;
		return this.depotAt.equals(that.depotAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(depotAt);
	}

	@Override
	public String toString() {
		return String.valueOf(depotAt);
	}
}
