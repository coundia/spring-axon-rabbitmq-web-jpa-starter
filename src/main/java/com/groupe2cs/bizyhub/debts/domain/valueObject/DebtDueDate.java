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
public class DebtDueDate implements Serializable {

private java.time.Instant dueDate;

public DebtDueDate(java.time.Instant dueDate) {
this.dueDate = dueDate;
}

public static DebtDueDate create(java.time.Instant dueDate) {

	return new DebtDueDate(dueDate);
}

public java.time.Instant value() {
return this.dueDate;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtDueDate that)) return false;
return this.dueDate.equals(that.dueDate);
}

@Override
public int hashCode() {
return java.util.Objects.hash(dueDate);
}

@Override
public String toString() {
return String.valueOf(dueDate);
}
}
