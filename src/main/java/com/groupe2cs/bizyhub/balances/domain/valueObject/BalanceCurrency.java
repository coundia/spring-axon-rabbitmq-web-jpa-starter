package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;

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
public class BalanceCurrency implements Serializable {

private String currency;

public BalanceCurrency(String currency) {
this.currency = currency;
}

public static BalanceCurrency create(String currency) {

if (currency == null || currency.isBlank()) {
throw new BalanceCurrencyNotValid("Currency is invalid");
}
return new BalanceCurrency(currency);
}

public String value() {
return this.currency;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceCurrency that)) return false;
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
