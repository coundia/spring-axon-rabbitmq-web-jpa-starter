package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;

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
public class SettingValue implements Serializable {

private String value;

public SettingValue(String value) {
this.value = value;
}

public static SettingValue create(String value) {

if (value == null || value.isBlank()) {
throw new SettingValueNotValid("Value is invalid");
}
return new SettingValue(value);
}

public String value() {
return this.value;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingValue that)) return false;
return this.value.equals(that.value);
}

@Override
public int hashCode() {
return java.util.Objects.hash(value);
}

@Override
public String toString() {
return String.valueOf(value);
}
}
