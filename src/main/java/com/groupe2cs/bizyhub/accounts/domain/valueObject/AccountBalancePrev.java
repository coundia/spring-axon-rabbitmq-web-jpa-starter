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
public class AccountBalancePrev implements Serializable {

private Double balancePrev;

public AccountBalancePrev(Double balancePrev) {
this.balancePrev = balancePrev;
}

public static AccountBalancePrev create(Double balancePrev) {

if (balancePrev == null) {
throw new AccountBalancePrevNotValid("BalancePrev is invalid");
}
return new AccountBalancePrev(balancePrev);
}

public Double value() {
return this.balancePrev;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalancePrev that)) return false;
return this.balancePrev.equals(that.balancePrev);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balancePrev);
}

@Override
public String toString() {
return String.valueOf(balancePrev);
}
}
