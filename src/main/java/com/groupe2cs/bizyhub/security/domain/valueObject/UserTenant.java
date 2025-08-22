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
import com.groupe2cs.bizyhub.security.domain.exception.UserTenantNotValid;

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
public class UserTenant implements Serializable {

private String tenant;

public UserTenant(String tenant) {
this.tenant = tenant;
}

public static UserTenant create(String tenant) {

	return new UserTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
