package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserFirstNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserLastNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserEmailNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserTelephoneNotValid;

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
public class UserTelephone implements Serializable {

	private String telephone;

	public UserTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static UserTelephone create(String telephone) {

		return new UserTelephone(telephone);
	}

	public String value() {
		return this.telephone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserTelephone that)) return false;
		return this.telephone.equals(that.telephone);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(telephone);
	}

	@Override
	public String toString() {
		return String.valueOf(telephone);
	}
}
