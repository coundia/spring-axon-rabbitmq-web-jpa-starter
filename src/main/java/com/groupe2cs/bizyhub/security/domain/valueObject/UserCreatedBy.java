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
import com.groupe2cs.bizyhub.security.domain.exception.UserIsPremiumNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserEnabledNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserIsBanNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserMessageNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserCreatedByNotValid;

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
public class UserCreatedBy implements Serializable {

	private String createdBy;

	public UserCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static UserCreatedBy create(String createdBy) {

		return new UserCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserCreatedBy that)) return false;
		return this.createdBy.equals(that.createdBy);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(createdBy);
	}

	@Override
	public String toString() {
		return String.valueOf(createdBy);
	}
}
