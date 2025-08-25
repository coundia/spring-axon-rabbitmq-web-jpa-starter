package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTypeEntryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntityNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntityIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCompanyNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCustomerNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDebtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedByNotValid;

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
public class TransactionCreatedBy implements Serializable {

private String createdBy;

public TransactionCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static TransactionCreatedBy create(String createdBy) {

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
