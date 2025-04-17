package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsReferenceNotValid;

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
public class TransactionsReference implements Serializable {

private String reference;

public TransactionsReference(String reference) {
this.reference = reference;
}

public static TransactionsReference create(String reference) {
if (reference == null || reference.isBlank()) {
throw new TransactionsReferenceNotValid("Reference is invalid");
}
return new TransactionsReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionsReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
