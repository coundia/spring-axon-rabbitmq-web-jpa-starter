package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDetailsNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsActiveNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTypeTransactionRawNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateTransactionNotValid;

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
public class TransactionDateTransaction implements Serializable {

private java.time.Instant dateTransaction;

public TransactionDateTransaction(java.time.Instant dateTransaction) {
this.dateTransaction = dateTransaction;
}

public static TransactionDateTransaction create(java.time.Instant dateTransaction) {

	return new TransactionDateTransaction(dateTransaction);
}

public java.time.Instant value() {
return this.dateTransaction;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionDateTransaction that)) return false;
return this.dateTransaction.equals(that.dateTransaction);
}

@Override
public int hashCode() {
return java.util.Objects.hash(dateTransaction);
}

@Override
public String toString() {
return String.valueOf(dateTransaction);
}
}
