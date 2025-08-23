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
public class AccountIsDefault implements Serializable {

private Boolean isDefault;

public AccountIsDefault(Boolean isDefault) {
this.isDefault = isDefault;
}

public static AccountIsDefault create(Boolean isDefault) {

	return new AccountIsDefault(isDefault);
}

public Boolean value() {
return this.isDefault;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountIsDefault that)) return false;
return this.isDefault.equals(that.isDefault);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isDefault);
}

@Override
public String toString() {
return String.valueOf(isDefault);
}
}
