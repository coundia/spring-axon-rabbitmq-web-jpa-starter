package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTransactionNotValid;

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
public class TransactionUserTransaction implements Serializable {

private String transaction;

public TransactionUserTransaction(String transaction) {
this.transaction = transaction;
}

public static TransactionUserTransaction create(String transaction) {

	return new TransactionUserTransaction(transaction);
}

public String value() {
return this.transaction;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserTransaction that)) return false;
return this.transaction.equals(that.transaction);
}

@Override
public int hashCode() {
return java.util.Objects.hash(transaction);
}

@Override
public String toString() {
return String.valueOf(transaction);
}
}
