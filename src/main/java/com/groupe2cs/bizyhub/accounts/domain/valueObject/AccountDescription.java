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
public class AccountDescription implements Serializable {

private String description;

public AccountDescription(String description) {
this.description = description;
}

public static AccountDescription create(String description) {

	return new AccountDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountDescription that)) return false;
return this.description.equals(that.description);
}

@Override
public int hashCode() {
return java.util.Objects.hash(description);
}

@Override
public String toString() {
return String.valueOf(description);
}
}
