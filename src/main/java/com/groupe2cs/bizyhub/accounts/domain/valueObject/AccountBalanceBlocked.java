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
public class AccountBalanceBlocked implements Serializable {

private Double balanceBlocked;

public AccountBalanceBlocked(Double balanceBlocked) {
this.balanceBlocked = balanceBlocked;
}

public static AccountBalanceBlocked create(Double balanceBlocked) {

if (balanceBlocked == null) {
throw new AccountBalanceBlockedNotValid("BalanceBlocked is invalid");
}
return new AccountBalanceBlocked(balanceBlocked);
}

public Double value() {
return this.balanceBlocked;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalanceBlocked that)) return false;
return this.balanceBlocked.equals(that.balanceBlocked);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balanceBlocked);
}

@Override
public String toString() {
return String.valueOf(balanceBlocked);
}
}
