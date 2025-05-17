package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;

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
public class SettingLocale implements Serializable {

private String locale;

public SettingLocale(String locale) {
this.locale = locale;
}

public static SettingLocale create(String locale) {

if (locale == null || locale.isBlank()) {
throw new SettingLocaleNotValid("Locale is invalid");
}
return new SettingLocale(locale);
}

public String value() {
return this.locale;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingLocale that)) return false;
return this.locale.equals(that.locale);
}

@Override
public int hashCode() {
return java.util.Objects.hash(locale);
}

@Override
public String toString() {
return String.valueOf(locale);
}
}
