package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCodeNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountTypeAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceNotValid;

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
public class AccountBalance implements Serializable {

private Double balance;

public AccountBalance(Double balance) {
this.balance = balance;
}

public static AccountBalance create(Double balance) {

if (balance == null) {
throw new AccountBalanceNotValid("Balance is invalid");
}
return new AccountBalance(balance);
}

public Double value() {
return this.balance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountBalance that)) return false;
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
