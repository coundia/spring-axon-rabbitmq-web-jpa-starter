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
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCompanyNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCustomerNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDebtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedByNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTenantNotValid;

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
public class TransactionTenant implements Serializable {

private String tenant;

public TransactionTenant(String tenant) {
this.tenant = tenant;
}

public static TransactionTenant create(String tenant) {

	return new TransactionTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionTenant that)) return false;
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
