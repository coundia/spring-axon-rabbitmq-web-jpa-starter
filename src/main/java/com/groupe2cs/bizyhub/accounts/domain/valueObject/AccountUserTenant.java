package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUsernameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserDetailsNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserCreatedByNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserTenantNotValid;

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
public class AccountUserTenant implements Serializable {

private String tenant;

public AccountUserTenant(String tenant) {
this.tenant = tenant;
}

public static AccountUserTenant create(String tenant) {

	return new AccountUserTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserTenant that)) return false;
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
