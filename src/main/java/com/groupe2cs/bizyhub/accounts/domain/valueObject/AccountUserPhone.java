package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserAccountNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserUserNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserPhoneNotValid;

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
public class AccountUserPhone implements Serializable {

private String phone;

public AccountUserPhone(String phone) {
this.phone = phone;
}

public static AccountUserPhone create(String phone) {

	return new AccountUserPhone(phone);
}

public String value() {
return this.phone;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof AccountUserPhone that)) return false;
return this.phone.equals(that.phone);
}

@Override
public int hashCode() {
return java.util.Objects.hash(phone);
}

@Override
public String toString() {
return String.valueOf(phone);
}
}
