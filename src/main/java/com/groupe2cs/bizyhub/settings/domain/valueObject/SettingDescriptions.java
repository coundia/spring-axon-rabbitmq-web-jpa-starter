package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingReferenceNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingUpdatedAtNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingStringValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDescriptionsNotValid;

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
public class SettingDescriptions implements Serializable {

private String descriptions;

public SettingDescriptions(String descriptions) {
this.descriptions = descriptions;
}

public static SettingDescriptions create(String descriptions) {

	return new SettingDescriptions(descriptions);
}

public String value() {
return this.descriptions;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingDescriptions that)) return false;
return this.descriptions.equals(that.descriptions);
}

@Override
public int hashCode() {
return java.util.Objects.hash(descriptions);
}

@Override
public String toString() {
return String.valueOf(descriptions);
}
}
