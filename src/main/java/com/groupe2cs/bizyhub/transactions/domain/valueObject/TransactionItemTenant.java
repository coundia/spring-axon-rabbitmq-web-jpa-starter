package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTotalNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemNotesNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemCreatedByNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTenantNotValid;

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
public class TransactionItemTenant implements Serializable {

private String tenant;

public TransactionItemTenant(String tenant) {
this.tenant = tenant;
}

public static TransactionItemTenant create(String tenant) {

	return new TransactionItemTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemTenant that)) return false;
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
