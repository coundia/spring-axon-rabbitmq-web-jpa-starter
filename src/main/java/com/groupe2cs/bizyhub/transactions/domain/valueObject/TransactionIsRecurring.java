package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateOperationNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsRecurringNotValid;

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
public class TransactionIsRecurring implements Serializable {

private Boolean isRecurring;

public TransactionIsRecurring(Boolean isRecurring) {
this.isRecurring = isRecurring;
}

public static TransactionIsRecurring create(Boolean isRecurring) {
if (isRecurring == null) {
throw new TransactionIsRecurringNotValid("IsRecurring is invalid");
}
return new TransactionIsRecurring(isRecurring);
}

public Boolean value() {
return this.isRecurring;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionIsRecurring that)) return false;
return this.isRecurring.equals(that.isRecurring);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isRecurring);
}

@Override
public String toString() {
return String.valueOf(isRecurring);
}
}
