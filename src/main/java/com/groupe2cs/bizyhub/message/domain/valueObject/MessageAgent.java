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
public class MessageAgent implements Serializable {

	private String agent;

	public MessageAgent(String agent) {
		this.agent = agent;
	}

	public static MessageAgent create(String agent) {

		return new MessageAgent(agent);
	}

	public String value() {
		return this.agent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageAgent that)) return false;
		return this.agent.equals(that.agent);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(agent);
	}

	@Override
	public String toString() {
		return String.valueOf(agent);
	}
}
