package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserNameNotValid;

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
public class AccountUserName implements Serializable {

private String name;

public AccountUserName(String name) {
this.name = name;
}

public static AccountUserName create(String name) {

if (name == null || name.isBlank()) {
throw new AccountUserNameNotValid("Name is invalid");
}
return new AccountUserName(name);
}

public String value() {
return this.name;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserName that)) return false;
return this.name.equals(that.name);
}

@Override
public int hashCode() {
return java.util.Objects.hash(name);
}

@Override
public String toString() {
return String.valueOf(name);
}
}
