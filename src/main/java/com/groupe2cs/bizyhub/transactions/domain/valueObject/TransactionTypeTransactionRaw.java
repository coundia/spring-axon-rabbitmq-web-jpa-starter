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
public class TransactionTypeTransactionRaw implements Serializable {

private String typeTransactionRaw;

public TransactionTypeTransactionRaw(String typeTransactionRaw) {
this.typeTransactionRaw = typeTransactionRaw;
}

public static TransactionTypeTransactionRaw create(String typeTransactionRaw) {

	return new TransactionTypeTransactionRaw(typeTransactionRaw);
}

public String value() {
return this.typeTransactionRaw;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionTypeTransactionRaw that)) return false;
return this.typeTransactionRaw.equals(that.typeTransactionRaw);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeTransactionRaw);
}

@Override
public String toString() {
return String.valueOf(typeTransactionRaw);
}
}
