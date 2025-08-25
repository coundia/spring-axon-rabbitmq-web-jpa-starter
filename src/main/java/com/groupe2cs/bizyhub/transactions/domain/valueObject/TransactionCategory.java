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
public class TransactionCategory implements Serializable {

private String category;

public TransactionCategory(String category) {
this.category = category;
}

public static TransactionCategory create(String category) {

	return new TransactionCategory(category);
}

public String value() {
return this.category;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionCategory that)) return false;
return this.category.equals(that.category);
}

@Override
public int hashCode() {
return java.util.Objects.hash(category);
}

@Override
public String toString() {
return String.valueOf(category);
}
}
