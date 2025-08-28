package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingRemoteIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocalIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingAccountNotValid;

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
public class SettingAccount implements Serializable {

private String account;

public SettingAccount(String account) {
this.account = account;
}

public static SettingAccount create(String account) {

	return new SettingAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingAccount that)) return false;
return this.account.equals(that.account);
}

@Override
public int hashCode() {
return java.util.Objects.hash(account);
}

@Override
public String toString() {
return String.valueOf(account);
}
}
