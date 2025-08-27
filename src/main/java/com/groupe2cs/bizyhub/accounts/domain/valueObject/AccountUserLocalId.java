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
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserLocalIdNotValid;

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
public class AccountUserLocalId implements Serializable {

private String localId;

public AccountUserLocalId(String localId) {
this.localId = localId;
}

public static AccountUserLocalId create(String localId) {

	return new AccountUserLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
