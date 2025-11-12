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
public class OrderDateCommand implements Serializable {

	private java.time.Instant dateCommand;

	public OrderDateCommand(java.time.Instant dateCommand) {
		this.dateCommand = dateCommand;
	}

	public static OrderDateCommand create(java.time.Instant dateCommand) {

		return new OrderDateCommand(dateCommand);
	}

	public java.time.Instant value() {
		return this.dateCommand;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderDateCommand that)) return false;
		return this.dateCommand.equals(that.dateCommand);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(dateCommand);
	}

	@Override
	public String toString() {
		return String.valueOf(dateCommand);
	}
}
