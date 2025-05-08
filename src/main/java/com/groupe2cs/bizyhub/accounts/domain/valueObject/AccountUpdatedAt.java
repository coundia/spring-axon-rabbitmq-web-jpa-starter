package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountPreviousBalanceNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountDetailsNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUpdatedAtNotValid;

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
public class AccountUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public AccountUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static AccountUpdatedAt create(java.time.Instant updatedAt) {

	return new AccountUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUpdatedAt that)) return false;
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
