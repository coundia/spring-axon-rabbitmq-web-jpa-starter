package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdentityNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserPhoneNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserEmailNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserRoleNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserInvitedByNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserSyncAtNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAcceptedAtNotValid;

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
public class AccountUserAcceptedAt implements Serializable {

private java.time.Instant acceptedAt;

public AccountUserAcceptedAt(java.time.Instant acceptedAt) {
this.acceptedAt = acceptedAt;
}

public static AccountUserAcceptedAt create(java.time.Instant acceptedAt) {

	return new AccountUserAcceptedAt(acceptedAt);
}

public java.time.Instant value() {
return this.acceptedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserAcceptedAt that)) return false;
return this.acceptedAt.equals(that.acceptedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(acceptedAt);
}

@Override
public String toString() {
return String.valueOf(acceptedAt);
}
}
