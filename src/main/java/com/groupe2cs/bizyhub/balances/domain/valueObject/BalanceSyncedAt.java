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
public class BalanceSyncedAt implements Serializable {

private java.time.Instant syncedAt;

public BalanceSyncedAt(java.time.Instant syncedAt) {
this.syncedAt = syncedAt;
}

public static BalanceSyncedAt create(java.time.Instant syncedAt) {

	return new BalanceSyncedAt(syncedAt);
}

public java.time.Instant value() {
return this.syncedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceSyncedAt that)) return false;
return this.syncedAt.equals(that.syncedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncedAt);
}

@Override
public String toString() {
return String.valueOf(syncedAt);
}
}
