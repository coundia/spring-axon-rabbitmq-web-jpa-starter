package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;

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
public class TransactionItemSyncAt implements Serializable {

private java.time.Instant syncAt;

public TransactionItemSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static TransactionItemSyncAt create(java.time.Instant syncAt) {

	return new TransactionItemSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
