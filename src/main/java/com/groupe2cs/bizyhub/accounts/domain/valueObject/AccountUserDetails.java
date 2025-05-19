package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUsernameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserDetailsNotValid;

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
public class AccountUserDetails implements Serializable {

private String details;

public AccountUserDetails(String details) {
this.details = details;
}

public static AccountUserDetails create(String details) {

	return new AccountUserDetails(details);
}

public String value() {
return this.details;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserDetails that)) return false;
return this.details.equals(that.details);
}

@Override
public int hashCode() {
return java.util.Objects.hash(details);
}

@Override
public String toString() {
return String.valueOf(details);
}
}
