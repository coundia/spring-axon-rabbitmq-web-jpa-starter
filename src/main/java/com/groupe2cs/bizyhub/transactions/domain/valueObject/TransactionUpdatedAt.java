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
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUpdatedAtNotValid;

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
public class TransactionUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public TransactionUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static TransactionUpdatedAt create(java.time.Instant updatedAt) {

	return new TransactionUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUpdatedAt that)) return false;
return this.updatedAt.equals(that.updatedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(updatedAt);
}

@Override
public String toString() {
return String.valueOf(updatedAt);
}
}
