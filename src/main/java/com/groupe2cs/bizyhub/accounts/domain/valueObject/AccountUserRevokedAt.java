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
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserRevokedAtNotValid;

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
public class AccountUserRevokedAt implements Serializable {

private java.time.Instant revokedAt;

public AccountUserRevokedAt(java.time.Instant revokedAt) {
this.revokedAt = revokedAt;
}

public static AccountUserRevokedAt create(java.time.Instant revokedAt) {

	return new AccountUserRevokedAt(revokedAt);
}

public java.time.Instant value() {
return this.revokedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserRevokedAt that)) return false;
return this.revokedAt.equals(that.revokedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(revokedAt);
}

@Override
public String toString() {
return String.valueOf(revokedAt);
}
}
