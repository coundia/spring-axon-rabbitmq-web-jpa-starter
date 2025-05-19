package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUserNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUsernameNotValid;

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
public class TransactionUserUsername implements Serializable {

private String username;

public TransactionUserUsername(String username) {
this.username = username;
}

public static TransactionUserUsername create(String username) {

	return new TransactionUserUsername(username);
}

public String value() {
return this.username;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserUsername that)) return false;
return this.username.equals(that.username);
}

@Override
public int hashCode() {
return java.util.Objects.hash(username);
}

@Override
public String toString() {
return String.valueOf(username);
}
}
