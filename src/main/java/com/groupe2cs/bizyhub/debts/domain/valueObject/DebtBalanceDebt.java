package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceDebtNotValid;

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
public class DebtBalanceDebt implements Serializable {

private Double balanceDebt;

public DebtBalanceDebt(Double balanceDebt) {
this.balanceDebt = balanceDebt;
}

public static DebtBalanceDebt create(Double balanceDebt) {

if (balanceDebt == null) {
throw new DebtBalanceDebtNotValid("BalanceDebt is invalid");
}
return new DebtBalanceDebt(balanceDebt);
}

public Double value() {
return this.balanceDebt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtBalanceDebt that)) return false;
return this.balanceDebt.equals(that.balanceDebt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balanceDebt);
}

@Override
public String toString() {
return String.valueOf(balanceDebt);
}
}
