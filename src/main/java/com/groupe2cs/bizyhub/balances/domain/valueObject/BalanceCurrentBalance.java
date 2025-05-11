package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;

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
public class BalanceCurrentBalance implements Serializable {

private Double currentBalance;

public BalanceCurrentBalance(Double currentBalance) {
this.currentBalance = currentBalance;
}

public static BalanceCurrentBalance create(Double currentBalance) {

if (currentBalance == null) {
throw new BalanceCurrentBalanceNotValid("CurrentBalance is invalid");
}
return new BalanceCurrentBalance(currentBalance);
}

public Double value() {
return this.currentBalance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceCurrentBalance that)) return false;
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
