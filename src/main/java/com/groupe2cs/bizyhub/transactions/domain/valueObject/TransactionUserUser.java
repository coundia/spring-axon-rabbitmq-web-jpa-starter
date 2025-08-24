package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUserNotValid;

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
public class TransactionUserUser implements Serializable {

private String user;

public TransactionUserUser(String user) {
this.user = user;
}

public static TransactionUserUser create(String user) {

	return new TransactionUserUser(user);
}

public String value() {
return this.user;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserUser that)) return false;
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
