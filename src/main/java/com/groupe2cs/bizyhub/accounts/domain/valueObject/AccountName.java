package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;

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
public class AccountName implements Serializable {

private String name;

public AccountName(String name) {
this.name = name;
}

public static AccountName create(String name) {

if (name == null || name.isBlank()) {
throw new AccountNameNotValid("Name is invalid");
}
return new AccountName(name);
}

public String value() {
return this.name;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountName that)) return false;
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
