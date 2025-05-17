package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUserNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUsernameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserDetailsNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIsActiveNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUpdatedAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserReferenceNotValid;

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
public class TransactionUserReference implements Serializable {

private String reference;

public TransactionUserReference(String reference) {
this.reference = reference;
}

public static TransactionUserReference create(String reference) {

	return new TransactionUserReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserReference that)) return false;
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
