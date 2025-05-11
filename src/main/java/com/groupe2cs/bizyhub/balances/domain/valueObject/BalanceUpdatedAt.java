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
public class BalanceUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public BalanceUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static BalanceUpdatedAt create(java.time.Instant updatedAt) {

	return new BalanceUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceUpdatedAt that)) return false;
return this.updatedAt.equals(that.updatedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(updatedAt);
}

@Override
public String toString() {
return String.valueOf(updatedAt);
}
}
