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
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserMessageNotValid;

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
public class AccountUserMessage implements Serializable {

private String message;

public AccountUserMessage(String message) {
this.message = message;
}

public static AccountUserMessage create(String message) {

	return new AccountUserMessage(message);
}

public String value() {
return this.message;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserMessage that)) return false;
return this.message.equals(that.message);
}

@Override
public int hashCode() {
return java.util.Objects.hash(message);
}

@Override
public String toString() {
return String.valueOf(message);
}
}
