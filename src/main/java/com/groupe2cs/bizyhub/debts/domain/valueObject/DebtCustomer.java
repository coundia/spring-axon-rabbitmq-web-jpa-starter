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
import com.groupe2cs.bizyhub.debts.domain.exception.DebtAccountNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtSyncAtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCustomerNotValid;

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
public class DebtCustomer implements Serializable {

private String customer;

public DebtCustomer(String customer) {
this.customer = customer;
}

public static DebtCustomer create(String customer) {

	return new DebtCustomer(customer);
}

public String value() {
return this.customer;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtCustomer that)) return false;
return this.customer.equals(that.customer);
}

@Override
public int hashCode() {
return java.util.Objects.hash(customer);
}

@Override
public String toString() {
return String.valueOf(customer);
}
}
