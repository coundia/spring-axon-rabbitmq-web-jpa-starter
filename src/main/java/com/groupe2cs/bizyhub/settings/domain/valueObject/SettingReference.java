package com.groupe2cs.bizyhub.settings.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIdNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingNameNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingStringValueNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingDescriptionNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingIsActiveNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingUpdatedAtNotValid;
import com.groupe2cs.bizyhub.settings.domain.exception.SettingReferenceNotValid;

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
public class SettingReference implements Serializable {

private String reference;

public SettingReference(String reference) {
this.reference = reference;
}

public static SettingReference create(String reference) {

	return new SettingReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SettingReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
