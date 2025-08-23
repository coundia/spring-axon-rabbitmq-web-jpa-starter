package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCodeNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountStatusNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountTypeAccountNotValid;

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
public class AccountTypeAccount implements Serializable {

private String typeAccount;

public AccountTypeAccount(String typeAccount) {
this.typeAccount = typeAccount;
}

public static AccountTypeAccount create(String typeAccount) {

	return new AccountTypeAccount(typeAccount);
}

public String value() {
return this.typeAccount;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountTypeAccount that)) return false;
return this.typeAccount.equals(that.typeAccount);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeAccount);
}

@Override
public String toString() {
return String.valueOf(typeAccount);
}
}
