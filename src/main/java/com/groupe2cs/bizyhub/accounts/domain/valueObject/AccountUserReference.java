package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUsernameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserDetailsNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUpdatedAtNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserReferenceNotValid;

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
public class AccountUserReference implements Serializable {

private String reference;

public AccountUserReference(String reference) {
this.reference = reference;
}

public static AccountUserReference create(String reference) {

	return new AccountUserReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
