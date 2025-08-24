package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDetailsNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsActiveNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTypeEntryNotValid;

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
public class TransactionTypeEntry implements Serializable {

private String typeEntry;

public TransactionTypeEntry(String typeEntry) {
this.typeEntry = typeEntry;
}

public static TransactionTypeEntry create(String typeEntry) {

	return new TransactionTypeEntry(typeEntry);
}

public String value() {
return this.typeEntry;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionTypeEntry that)) return false;
return this.typeEntry.equals(that.typeEntry);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeEntry);
}

@Override
public String toString() {
return String.valueOf(typeEntry);
}
}
