package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdentityNotValid;

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
public class AccountUserIdentity implements Serializable {

private String identity;

public AccountUserIdentity(String identity) {
this.identity = identity;
}

public static AccountUserIdentity create(String identity) {

	return new AccountUserIdentity(identity);
}

public String value() {
return this.identity;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserIdentity that)) return false;
return this.identity.equals(that.identity);
}

@Override
public int hashCode() {
return java.util.Objects.hash(identity);
}

@Override
public String toString() {
return String.valueOf(identity);
}
}
