package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalancePreviousBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceLastUpdatedNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsDefaultNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceOrdreNotValid;

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
public class BalanceOrdre implements Serializable {

private Integer ordre;

public BalanceOrdre(Integer ordre) {
this.ordre = ordre;
}

public static BalanceOrdre create(Integer ordre) {

if (ordre < 0) {
throw new BalanceOrdreNotValid("Ordre is invalid");
}
return new BalanceOrdre(ordre);
}

public Integer value() {
return this.ordre;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceOrdre that)) return false;
return this.ordre.equals(that.ordre);
}

@Override
public int hashCode() {
return java.util.Objects.hash(ordre);
}

@Override
public String toString() {
return String.valueOf(ordre);
}
}
