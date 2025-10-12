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
public class UserMessage implements Serializable {

	private String message;

	public UserMessage(String message) {
		this.message = message;
	}

	public static UserMessage create(String message) {

		return new UserMessage(message);
	}

	public String value() {
		return this.message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserMessage that)) return false;
		return this.message.equals(that.message);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(message);
	}

	@Override
	public String toString() {
		return String.valueOf(message);
	}
}
