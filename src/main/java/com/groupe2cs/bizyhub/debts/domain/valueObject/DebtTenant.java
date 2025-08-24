package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtLocalIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceDebtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtDueDateNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtStatusesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtSyncAtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCustomerNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIsActiveNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCreatedByNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtTenantNotValid;

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
public class DebtTenant implements Serializable {

private String tenant;

public DebtTenant(String tenant) {
this.tenant = tenant;
}

public static DebtTenant create(String tenant) {

	return new DebtTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtTenant that)) return false;
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
