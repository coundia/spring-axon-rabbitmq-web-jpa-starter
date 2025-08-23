package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDetailsNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingSyncAtNotValid;

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
public class SettingSyncAt implements Serializable {

private java.time.Instant syncAt;

public SettingSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static SettingSyncAt create(java.time.Instant syncAt) {

	return new SettingSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
