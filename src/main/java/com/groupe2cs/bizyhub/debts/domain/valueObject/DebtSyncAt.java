package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtLocalIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceDebtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtDueDateNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtStatusesNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtAccountNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtSyncAtNotValid;

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
public class DebtSyncAt implements Serializable {

private java.time.Instant syncAt;

public DebtSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static DebtSyncAt create(java.time.Instant syncAt) {

	return new DebtSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
