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
public class AccountLocalId implements Serializable {

private String localId;

public AccountLocalId(String localId) {
this.localId = localId;
}

public static AccountLocalId create(String localId) {

	return new AccountLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
