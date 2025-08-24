package com.groupe2cs.bizyhub.units.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.units.domain.exception.UnitIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitRemoteIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitLocalIdNotValid;

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
public class UnitLocalId implements Serializable {

private String localId;

public UnitLocalId(String localId) {
this.localId = localId;
}

public static UnitLocalId create(String localId) {

	return new UnitLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
