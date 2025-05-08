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
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountReferenceNotValid;

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
public class AccountReference implements Serializable {

private String reference;

public AccountReference(String reference) {
this.reference = reference;
}

public static AccountReference create(String reference) {

	return new AccountReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
