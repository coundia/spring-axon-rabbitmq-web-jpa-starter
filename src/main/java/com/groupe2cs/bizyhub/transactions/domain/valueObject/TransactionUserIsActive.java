package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUserNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserUsernameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserDetailsNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserIsActiveNotValid;

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
public class TransactionUserIsActive implements Serializable {

private Boolean isActive;

public TransactionUserIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static TransactionUserIsActive create(Boolean isActive) {

	return new TransactionUserIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserIsActive that)) return false;
return this.isActive.equals(that.isActive);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isActive);
}

@Override
public String toString() {
return String.valueOf(isActive);
}
}
