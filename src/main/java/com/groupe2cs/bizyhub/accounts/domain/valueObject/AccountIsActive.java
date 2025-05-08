package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountPreviousBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountDetailsNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsActiveNotValid;

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
public class AccountIsActive implements Serializable {

private Boolean isActive;

public AccountIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static AccountIsActive create(Boolean isActive) {

if (isActive == null) {
throw new AccountIsActiveNotValid("IsActive is invalid");
}
return new AccountIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountIsActive that)) return false;
return this.isActive.equals(that.isActive);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isActive);
}

@Override
public String toString() {
return String.valueOf(isActive);
}
}
