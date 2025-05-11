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
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsArchivedNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowDebitNotValid;

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
public class BalanceIsAllowDebit implements Serializable {

private Boolean isAllowDebit;

public BalanceIsAllowDebit(Boolean isAllowDebit) {
this.isAllowDebit = isAllowDebit;
}

public static BalanceIsAllowDebit create(Boolean isAllowDebit) {

if (isAllowDebit == null) {
throw new BalanceIsAllowDebitNotValid("IsAllowDebit is invalid");
}
return new BalanceIsAllowDebit(isAllowDebit);
}

public Boolean value() {
return this.isAllowDebit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceIsAllowDebit that)) return false;
return this.isAllowDebit.equals(that.isAllowDebit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isAllowDebit);
}

@Override
public String toString() {
return String.valueOf(isAllowDebit);
}
}
