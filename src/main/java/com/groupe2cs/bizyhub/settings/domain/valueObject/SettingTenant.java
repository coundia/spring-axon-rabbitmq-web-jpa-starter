package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingRemoteIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDetailsNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingSyncAtNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIsActiveNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingCreatedByNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingTenantNotValid;

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
public class SettingTenant implements Serializable {

private String tenant;

public SettingTenant(String tenant) {
this.tenant = tenant;
}

public static SettingTenant create(String tenant) {

	return new SettingTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
