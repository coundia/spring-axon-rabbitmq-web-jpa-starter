package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateOperationNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsRecurringNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsExcluToRapportNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionBalanceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUpdatedAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedAtNotValid;

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
public class TransactionCreatedAt implements Serializable {

private java.time.Instant createdAt;

public TransactionCreatedAt(java.time.Instant createdAt) {
this.createdAt = createdAt;
}

public static TransactionCreatedAt create(java.time.Instant createdAt) {
if (createdAt == null) {
throw new TransactionCreatedAtNotValid("CreatedAt is invalid");
}
return new TransactionCreatedAt(createdAt);
}

public java.time.Instant value() {
return this.createdAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionCreatedAt that)) return false;
return this.createdAt.equals(that.createdAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdAt);
}

@Override
public String toString() {
return String.valueOf(createdAt);
}
}
