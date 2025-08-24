package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTotalNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemNotesNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemCreatedByNotValid;

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
public class TransactionItemCreatedBy implements Serializable {

private String createdBy;

public TransactionItemCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static TransactionItemCreatedBy create(String createdBy) {

	return new TransactionItemCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemCreatedBy that)) return false;
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
