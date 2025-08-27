package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;

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
public class TransactionItemTransaction implements Serializable {

private String transaction;

public TransactionItemTransaction(String transaction) {
this.transaction = transaction;
}

public static TransactionItemTransaction create(String transaction) {

	return new TransactionItemTransaction(transaction);
}

public String value() {
return this.transaction;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemTransaction that)) return false;
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
