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
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceActivateNotificationNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceSyncedAtNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceUpdatedAtNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceReferenceNotValid;

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
public class BalanceReference implements Serializable {

private String reference;

public BalanceReference(String reference) {
this.reference = reference;
}

public static BalanceReference create(String reference) {

	return new BalanceReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
