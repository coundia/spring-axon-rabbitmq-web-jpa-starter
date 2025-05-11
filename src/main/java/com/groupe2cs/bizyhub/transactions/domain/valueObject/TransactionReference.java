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
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;

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
public class TransactionReference implements Serializable {

private String reference;

public TransactionReference(String reference) {
this.reference = reference;
}

public static TransactionReference create(String reference) {

	return new TransactionReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
