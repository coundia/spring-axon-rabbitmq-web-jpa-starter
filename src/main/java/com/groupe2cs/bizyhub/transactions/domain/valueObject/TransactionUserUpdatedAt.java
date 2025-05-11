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
public class TransactionUserUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public TransactionUserUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static TransactionUserUpdatedAt create(java.time.Instant updatedAt) {

	return new TransactionUserUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserUpdatedAt that)) return false;
return this.updatedAt.equals(that.updatedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(updatedAt);
}

@Override
public String toString() {
return String.valueOf(updatedAt);
}
}
