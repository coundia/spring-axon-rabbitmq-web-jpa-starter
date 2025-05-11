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
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserCreatedByNotValid;

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
public class TransactionUserCreatedBy implements Serializable {

private String createdBy;

public TransactionUserCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static TransactionUserCreatedBy create(String createdBy) {

	return new TransactionUserCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserCreatedBy that)) return false;
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
