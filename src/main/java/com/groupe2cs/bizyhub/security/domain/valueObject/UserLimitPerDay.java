package com.groupe2cs.bizyhub.security.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserLimitPerDay implements Serializable {

	private Integer limitPerDay;

	public UserLimitPerDay(Integer limitPerDay) {
		this.limitPerDay = limitPerDay;
	}

	public static UserLimitPerDay create(Integer limitPerDay) {

		return new UserLimitPerDay(limitPerDay);
	}

	public Integer value() {
		return this.limitPerDay;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserLimitPerDay that)) return false;
		return this.limitPerDay.equals(that.limitPerDay);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(limitPerDay);
	}

	@Override
	public String toString() {
		return String.valueOf(limitPerDay);
	}
}
