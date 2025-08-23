package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryTypeEntryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDateTransactionNotValid;

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
public class TransactionEntryDateTransaction implements Serializable {

private java.time.Instant dateTransaction;

public TransactionEntryDateTransaction(java.time.Instant dateTransaction) {
this.dateTransaction = dateTransaction;
}

public static TransactionEntryDateTransaction create(java.time.Instant dateTransaction) {

	return new TransactionEntryDateTransaction(dateTransaction);
}

public java.time.Instant value() {
return this.dateTransaction;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryDateTransaction that)) return false;
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
