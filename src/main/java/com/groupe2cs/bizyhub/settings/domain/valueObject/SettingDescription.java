package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingStringValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDescriptionNotValid;

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
public class SettingDescription implements Serializable {

private String description;

public SettingDescription(String description) {
this.description = description;
}

public static SettingDescription create(String description) {

	return new SettingDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingDescription that)) return false;
return this.description.equals(that.description);
}

@Override
public int hashCode() {
return java.util.Objects.hash(description);
}

@Override
public String toString() {
return String.valueOf(description);
}
}
