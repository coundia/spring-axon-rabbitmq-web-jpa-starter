package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCodeNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountTypeAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalancePrevNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceBlockedNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceInitNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceGoalNotValid;

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
public class AccountBalanceGoal implements Serializable {

private Double balanceGoal;

public AccountBalanceGoal(Double balanceGoal) {
this.balanceGoal = balanceGoal;
}

public static AccountBalanceGoal create(Double balanceGoal) {

if (balanceGoal == null) {
throw new AccountBalanceGoalNotValid("BalanceGoal is invalid");
}
return new AccountBalanceGoal(balanceGoal);
}

public Double value() {
return this.balanceGoal;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalanceGoal that)) return false;
return this.balanceGoal.equals(that.balanceGoal);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balanceGoal);
}

@Override
public String toString() {
return String.valueOf(balanceGoal);
}
}
