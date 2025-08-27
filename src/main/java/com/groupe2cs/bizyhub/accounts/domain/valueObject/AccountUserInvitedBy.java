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
public class AccountUserInvitedBy implements Serializable {

private String invitedBy;

public AccountUserInvitedBy(String invitedBy) {
this.invitedBy = invitedBy;
}

public static AccountUserInvitedBy create(String invitedBy) {

	return new AccountUserInvitedBy(invitedBy);
}

public String value() {
return this.invitedBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserInvitedBy that)) return false;
return this.invitedBy.equals(that.invitedBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(invitedBy);
}

@Override
public String toString() {
return String.valueOf(invitedBy);
}
}
