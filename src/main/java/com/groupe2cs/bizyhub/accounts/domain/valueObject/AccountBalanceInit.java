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
public class AccountBalanceInit implements Serializable {

private Double balanceInit;

public AccountBalanceInit(Double balanceInit) {
this.balanceInit = balanceInit;
}

public static AccountBalanceInit create(Double balanceInit) {

if (balanceInit == null) {
throw new AccountBalanceInitNotValid("BalanceInit is invalid");
}
return new AccountBalanceInit(balanceInit);
}

public Double value() {
return this.balanceInit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalanceInit that)) return false;
return this.balanceInit.equals(that.balanceInit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balanceInit);
}

@Override
public String toString() {
return String.valueOf(balanceInit);
}
}
