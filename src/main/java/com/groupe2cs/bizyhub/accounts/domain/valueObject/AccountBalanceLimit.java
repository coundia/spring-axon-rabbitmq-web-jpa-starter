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
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceLimitNotValid;

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
public class AccountBalanceLimit implements Serializable {

private Double balanceLimit;

public AccountBalanceLimit(Double balanceLimit) {
this.balanceLimit = balanceLimit;
}

public static AccountBalanceLimit create(Double balanceLimit) {

if (balanceLimit == null) {
throw new AccountBalanceLimitNotValid("BalanceLimit is invalid");
}
return new AccountBalanceLimit(balanceLimit);
}

public Double value() {
return this.balanceLimit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalanceLimit that)) return false;
return this.balanceLimit.equals(that.balanceLimit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balanceLimit);
}

@Override
public String toString() {
return String.valueOf(balanceLimit);
}
}
