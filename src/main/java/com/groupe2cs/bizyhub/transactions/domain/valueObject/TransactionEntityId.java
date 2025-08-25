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
public class TransactionEntityId implements Serializable {

private String entityId;

public TransactionEntityId(String entityId) {
this.entityId = entityId;
}

public static TransactionEntityId create(String entityId) {

	return new TransactionEntityId(entityId);
}

public String value() {
return this.entityId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntityId that)) return false;
return this.entityId.equals(that.entityId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(entityId);
}

@Override
public String toString() {
return String.valueOf(entityId);
}
}
