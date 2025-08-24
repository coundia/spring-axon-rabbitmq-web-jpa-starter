package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;

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
public class TransactionItemRemoteId implements Serializable {

private String remoteId;

public TransactionItemRemoteId(String remoteId) {
this.remoteId = remoteId;
}

public static TransactionItemRemoteId create(String remoteId) {

	return new TransactionItemRemoteId(remoteId);
}

public String value() {
return this.remoteId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemRemoteId that)) return false;
return this.remoteId.equals(that.remoteId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(remoteId);
}

@Override
public String toString() {
return String.valueOf(remoteId);
}
}
