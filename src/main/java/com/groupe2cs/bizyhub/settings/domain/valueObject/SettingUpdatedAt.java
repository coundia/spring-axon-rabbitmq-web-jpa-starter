package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDetailsNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIsActiveNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingUpdatedAtNotValid;

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
public class SettingUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public SettingUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static SettingUpdatedAt create(java.time.Instant updatedAt) {

	return new SettingUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingUpdatedAt that)) return false;
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
