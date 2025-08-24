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
public class SettingCreatedBy implements Serializable {

private String createdBy;

public SettingCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static SettingCreatedBy create(String createdBy) {

	return new SettingCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingCreatedBy that)) return false;
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
