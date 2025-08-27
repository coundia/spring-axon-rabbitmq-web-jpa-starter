package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdentityNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserPhoneNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserEmailNotValid;

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
public class AccountUserEmail implements Serializable {

private String email;

public AccountUserEmail(String email) {
this.email = email;
}

public static AccountUserEmail create(String email) {

	return new AccountUserEmail(email);
}

public String value() {
return this.email;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserEmail that)) return false;
return this.email.equals(that.email);
}

@Override
public int hashCode() {
return java.util.Objects.hash(email);
}

@Override
public String toString() {
return String.valueOf(email);
}
}
