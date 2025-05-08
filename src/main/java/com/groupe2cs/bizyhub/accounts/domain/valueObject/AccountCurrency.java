package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;

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
public class AccountCurrency implements Serializable {

private String currency;

public AccountCurrency(String currency) {
this.currency = currency;
}

public static AccountCurrency create(String currency) {

if (currency == null || currency.isBlank()) {
throw new AccountCurrencyNotValid("Currency is invalid");
}
return new AccountCurrency(currency);
}

public String value() {
return this.currency;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountCurrency that)) return false;
return this.currency.equals(that.currency);
}

@Override
public int hashCode() {
return java.util.Objects.hash(currency);
}

@Override
public String toString() {
return String.valueOf(currency);
}
}
