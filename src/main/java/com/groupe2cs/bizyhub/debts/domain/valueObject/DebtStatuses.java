package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceDebtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtDueDateNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtStatusesNotValid;

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
public class DebtStatuses implements Serializable {

private String statuses;

public DebtStatuses(String statuses) {
this.statuses = statuses;
}

public static DebtStatuses create(String statuses) {

	return new DebtStatuses(statuses);
}

public String value() {
return this.statuses;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtStatuses that)) return false;
return this.statuses.equals(that.statuses);
}

@Override
public int hashCode() {
return java.util.Objects.hash(statuses);
}

@Override
public String toString() {
return String.valueOf(statuses);
}
}
