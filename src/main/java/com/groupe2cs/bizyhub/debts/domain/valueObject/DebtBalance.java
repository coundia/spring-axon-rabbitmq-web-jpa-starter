package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;

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
public class DebtBalance implements Serializable {

private Double balance;

public DebtBalance(Double balance) {
this.balance = balance;
}

public static DebtBalance create(Double balance) {

if (balance == null) {
throw new DebtBalanceNotValid("Balance is invalid");
}
return new DebtBalance(balance);
}

public Double value() {
return this.balance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtBalance that)) return false;
return this.balance.equals(that.balance);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balance);
}

@Override
public String toString() {
return String.valueOf(balance);
}
}
