package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedByNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTenantNotValid;

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
public class TransactionTenant implements Serializable {

private String tenant;

public TransactionTenant(String tenant) {
this.tenant = tenant;
}

public static TransactionTenant create(String tenant) {
if (tenant == null || tenant.isBlank()) {
throw new TransactionTenantNotValid("Tenant is invalid");
}
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
