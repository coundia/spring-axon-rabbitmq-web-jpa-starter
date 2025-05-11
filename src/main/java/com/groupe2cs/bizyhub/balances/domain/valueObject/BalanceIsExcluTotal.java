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
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowCreditNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsExcluTotalNotValid;

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
public class BalanceIsExcluTotal implements Serializable {

private Boolean isExcluTotal;

public BalanceIsExcluTotal(Boolean isExcluTotal) {
this.isExcluTotal = isExcluTotal;
}

public static BalanceIsExcluTotal create(Boolean isExcluTotal) {

if (isExcluTotal == null) {
throw new BalanceIsExcluTotalNotValid("IsExcluTotal is invalid");
}
return new BalanceIsExcluTotal(isExcluTotal);
}

public Boolean value() {
return this.isExcluTotal;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceIsExcluTotal that)) return false;
return this.isExcluTotal.equals(that.isExcluTotal);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isExcluTotal);
}

@Override
public String toString() {
return String.valueOf(isExcluTotal);
}
}
