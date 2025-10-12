package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserFirstNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserLastNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserEmailNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserTelephoneNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserLimitPerDayNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

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
