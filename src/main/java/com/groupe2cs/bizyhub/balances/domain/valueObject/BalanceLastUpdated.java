package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalancePreviousBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceLastUpdatedNotValid;

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
public class BalanceLastUpdated implements Serializable {

private java.time.Instant lastUpdated;

public BalanceLastUpdated(java.time.Instant lastUpdated) {
this.lastUpdated = lastUpdated;
}

public static BalanceLastUpdated create(java.time.Instant lastUpdated) {

if (lastUpdated == null) {
throw new BalanceLastUpdatedNotValid("LastUpdated is invalid");
}
return new BalanceLastUpdated(lastUpdated);
}

public java.time.Instant value() {
return this.lastUpdated;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceLastUpdated that)) return false;
return this.lastUpdated.equals(that.lastUpdated);
}

@Override
public int hashCode() {
return java.util.Objects.hash(lastUpdated);
}

@Override
public String toString() {
return String.valueOf(lastUpdated);
}
}
