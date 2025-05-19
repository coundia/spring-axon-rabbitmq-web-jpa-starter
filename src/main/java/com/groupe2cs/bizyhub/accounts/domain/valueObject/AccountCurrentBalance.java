package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;

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
public class AccountCurrentBalance implements Serializable {

private Double currentBalance;

public AccountCurrentBalance(Double currentBalance) {
this.currentBalance = currentBalance;
}

public static AccountCurrentBalance create(Double currentBalance) {

if (currentBalance == null) {
throw new AccountCurrentBalanceNotValid("CurrentBalance is invalid");
}
return new AccountCurrentBalance(currentBalance);
}

public Double value() {
return this.currentBalance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountCurrentBalance that)) return false;
return this.currentBalance.equals(that.currentBalance);
}

@Override
public int hashCode() {
return java.util.Objects.hash(currentBalance);
}

@Override
public String toString() {
return String.valueOf(currentBalance);
}
}
