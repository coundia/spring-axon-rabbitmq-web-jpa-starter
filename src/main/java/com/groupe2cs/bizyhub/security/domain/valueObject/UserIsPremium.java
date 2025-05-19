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
public class UserIsPremium implements Serializable {

private Boolean isPremium;

public UserIsPremium(Boolean isPremium) {
this.isPremium = isPremium;
}

public static UserIsPremium create(Boolean isPremium) {

	return new UserIsPremium(isPremium);
}

public Boolean value() {
return this.isPremium;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserIsPremium that)) return false;
return this.isPremium.equals(that.isPremium);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isPremium);
}

@Override
public String toString() {
return String.valueOf(isPremium);
}
}
