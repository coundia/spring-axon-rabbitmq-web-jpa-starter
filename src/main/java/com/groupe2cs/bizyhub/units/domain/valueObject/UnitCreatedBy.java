package com.groupe2cs.bizyhub.units.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.units.domain.exception.UnitIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitRemoteIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitLocalIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitCodeNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitNameNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitSyncAtNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitDescriptionNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitCreatedByNotValid;

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
public class UnitCreatedBy implements Serializable {

private String createdBy;

public UnitCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static UnitCreatedBy create(String createdBy) {

	return new UnitCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitCreatedBy that)) return false;
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
