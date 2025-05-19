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
public class UserIsBan implements Serializable {

private Boolean isBan;

public UserIsBan(Boolean isBan) {
this.isBan = isBan;
}

public static UserIsBan create(Boolean isBan) {

	return new UserIsBan(isBan);
}

public Boolean value() {
return this.isBan;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserIsBan that)) return false;
return this.isBan.equals(that.isBan);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isBan);
}

@Override
public String toString() {
return String.valueOf(isBan);
}
}
