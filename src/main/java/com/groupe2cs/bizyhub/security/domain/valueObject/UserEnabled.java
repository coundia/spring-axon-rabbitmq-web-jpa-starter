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
public class UserEnabled implements Serializable {

private Boolean enabled;

public UserEnabled(Boolean enabled) {
this.enabled = enabled;
}

public static UserEnabled create(Boolean enabled) {

	return new UserEnabled(enabled);
}

public Boolean value() {
return this.enabled;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserEnabled that)) return false;
return this.enabled.equals(that.enabled);
}

@Override
public int hashCode() {
return java.util.Objects.hash(enabled);
}

@Override
public String toString() {
return String.valueOf(enabled);
}
}
