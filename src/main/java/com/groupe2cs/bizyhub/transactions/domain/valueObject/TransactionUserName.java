package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;

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
public class TransactionUserName implements Serializable {

private String name;

public TransactionUserName(String name) {
this.name = name;
}

public static TransactionUserName create(String name) {

if (name == null || name.isBlank()) {
throw new TransactionUserNameNotValid("Name is invalid");
}
return new TransactionUserName(name);
}

public String value() {
return this.name;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserName that)) return false;
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
