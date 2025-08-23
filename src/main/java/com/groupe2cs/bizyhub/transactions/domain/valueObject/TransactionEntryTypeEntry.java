package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryTypeEntryNotValid;

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
public class TransactionEntryTypeEntry implements Serializable {

private String typeEntry;

public TransactionEntryTypeEntry(String typeEntry) {
this.typeEntry = typeEntry;
}

public static TransactionEntryTypeEntry create(String typeEntry) {

if (typeEntry == null || typeEntry.isBlank()) {
throw new TransactionEntryTypeEntryNotValid("TypeEntry is invalid");
}
return new TransactionEntryTypeEntry(typeEntry);
}

public String value() {
return this.typeEntry;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryTypeEntry that)) return false;
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
