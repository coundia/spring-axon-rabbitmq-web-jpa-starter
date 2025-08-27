package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserPhoneNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserRoleNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserInvitedByNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserSyncAtNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAcceptedAtNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserRevokedAtNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserMessageNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserRemoteIdNotValid;

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
public class AccountUserRemoteId implements Serializable {

private String remoteId;

public AccountUserRemoteId(String remoteId) {
this.remoteId = remoteId;
}

public static AccountUserRemoteId create(String remoteId) {

	return new AccountUserRemoteId(remoteId);
}

public String value() {
return this.remoteId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserRemoteId that)) return false;
return this.remoteId.equals(that.remoteId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(remoteId);
}

@Override
public String toString() {
return String.valueOf(remoteId);
}
}
