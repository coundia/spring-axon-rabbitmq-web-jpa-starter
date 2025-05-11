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
public class BalanceIsAllowCredit implements Serializable {

private Boolean isAllowCredit;

public BalanceIsAllowCredit(Boolean isAllowCredit) {
this.isAllowCredit = isAllowCredit;
}

public static BalanceIsAllowCredit create(Boolean isAllowCredit) {

if (isAllowCredit == null) {
throw new BalanceIsAllowCreditNotValid("IsAllowCredit is invalid");
}
return new BalanceIsAllowCredit(isAllowCredit);
}

public Boolean value() {
return this.isAllowCredit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceIsAllowCredit that)) return false;
return this.isAllowCredit.equals(that.isAllowCredit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isAllowCredit);
}

@Override
public String toString() {
return String.valueOf(isAllowCredit);
}
}
