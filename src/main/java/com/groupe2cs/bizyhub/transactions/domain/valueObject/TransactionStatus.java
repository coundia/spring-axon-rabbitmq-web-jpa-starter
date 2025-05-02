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
public class TransactionStatus implements Serializable {

private String status;

public TransactionStatus(String status) {
this.status = status;
}

public static TransactionStatus create(String status) {
if (status == null || status.isBlank()) {
throw new TransactionStatusNotValid("Status is invalid");
}
return new TransactionStatus(status);
}

public String value() {
return this.status;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionStatus that)) return false;
return this.status.equals(that.status);
}

@Override
public int hashCode() {
return java.util.Objects.hash(status);
}

@Override
public String toString() {
return String.valueOf(status);
}
}
