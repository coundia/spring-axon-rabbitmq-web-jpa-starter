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
public class DebtIsActive implements Serializable {

private Boolean isActive;

public DebtIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static DebtIsActive create(Boolean isActive) {

	return new DebtIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtIsActive that)) return false;
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
