package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;

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
public class AccountUserUser implements Serializable {

private String user;

public AccountUserUser(String user) {
this.user = user;
}

public static AccountUserUser create(String user) {

	return new AccountUserUser(user);
}

public String value() {
return this.user;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserUser that)) return false;
return this.user.equals(that.user);
}

@Override
public int hashCode() {
return java.util.Objects.hash(user);
}

@Override
public String toString() {
return String.valueOf(user);
}
}
