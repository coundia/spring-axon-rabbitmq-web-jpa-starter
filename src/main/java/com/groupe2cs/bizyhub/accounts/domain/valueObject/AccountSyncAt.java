package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCodeNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountTypeAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalancePrevNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceBlockedNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceInitNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceGoalNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceLimitNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountDescriptionNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsDefaultNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountRemoteIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountLocalIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountSyncAtNotValid;

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
public class AccountSyncAt implements Serializable {

private java.time.Instant syncAt;

public AccountSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static AccountSyncAt create(java.time.Instant syncAt) {

	return new AccountSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountSyncAt that)) return false;
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
