package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountPreviousBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountDetailsNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCreatedByNotValid;

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
public class AccountCreatedBy implements Serializable {

private String createdBy;

public AccountCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static AccountCreatedBy create(String createdBy) {

	return new AccountCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
