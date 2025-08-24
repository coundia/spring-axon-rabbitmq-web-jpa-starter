package com.groupe2cs.bizyhub.units.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.units.domain.exception.UnitIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitRemoteIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitLocalIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitCodeNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitNameNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitSyncAtNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitDescriptionNotValid;

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
public class UnitDescription implements Serializable {

private String description;

public UnitDescription(String description) {
this.description = description;
}

public static UnitDescription create(String description) {

	return new UnitDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitDescription that)) return false;
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
