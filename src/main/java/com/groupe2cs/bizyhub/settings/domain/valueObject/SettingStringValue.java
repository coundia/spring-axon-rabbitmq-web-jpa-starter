package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingStringValueNotValid;

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
public class SettingStringValue implements Serializable {

private String stringValue;

public SettingStringValue(String stringValue) {
this.stringValue = stringValue;
}

public static SettingStringValue create(String stringValue) {

if (stringValue == null || stringValue.isBlank()) {
throw new SettingStringValueNotValid("StringValue is invalid");
}
return new SettingStringValue(stringValue);
}

public String value() {
return this.stringValue;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingStringValue that)) return false;
return this.stringValue.equals(that.stringValue);
}

@Override
public int hashCode() {
return java.util.Objects.hash(stringValue);
}

@Override
public String toString() {
return String.valueOf(stringValue);
}
}
