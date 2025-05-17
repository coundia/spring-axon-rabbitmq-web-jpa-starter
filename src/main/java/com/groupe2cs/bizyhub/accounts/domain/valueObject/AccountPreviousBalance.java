package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountPreviousBalanceNotValid;

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
public class AccountPreviousBalance implements Serializable {

private Double previousBalance;

public AccountPreviousBalance(Double previousBalance) {
this.previousBalance = previousBalance;
}

public static AccountPreviousBalance create(Double previousBalance) {

if (previousBalance == null) {
throw new AccountPreviousBalanceNotValid("PreviousBalance is invalid");
}
return new AccountPreviousBalance(previousBalance);
}

public Double value() {
return this.previousBalance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountPreviousBalance that)) return false;
return this.previousBalance.equals(that.previousBalance);
}

@Override
public int hashCode() {
return java.util.Objects.hash(previousBalance);
}

@Override
public String toString() {
return String.valueOf(previousBalance);
}
}
