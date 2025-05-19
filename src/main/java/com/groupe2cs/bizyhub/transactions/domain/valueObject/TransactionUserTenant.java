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
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUserTenantNotValid;

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
public class TransactionUserTenant implements Serializable {

private String tenant;

public TransactionUserTenant(String tenant) {
this.tenant = tenant;
}

public static TransactionUserTenant create(String tenant) {

	return new TransactionUserTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionUserTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
