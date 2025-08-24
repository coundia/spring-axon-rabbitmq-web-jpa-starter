package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;

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
public class TransactionEntryDescription implements Serializable {

private String description;

public TransactionEntryDescription(String description) {
this.description = description;
}

public static TransactionEntryDescription create(String description) {

	return new TransactionEntryDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryDescription that)) return false;
return this.description.equals(that.description);
}

@Override
public int hashCode() {
return java.util.Objects.hash(description);
}

@Override
public String toString() {
return String.valueOf(description);
}
}
