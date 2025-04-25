package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedByNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionCreatedBy implements Serializable {

private String createdBy;

public TransactionCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static TransactionCreatedBy create(String createdBy) {
if (createdBy == null || createdBy.isBlank()) {
throw new TransactionCreatedByNotValid("CreatedBy is invalid");
}
return new TransactionCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
