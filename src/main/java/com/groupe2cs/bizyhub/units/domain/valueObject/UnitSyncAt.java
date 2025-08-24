package com.groupe2cs.bizyhub.units.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.units.domain.exception.UnitIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitRemoteIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitLocalIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitCodeNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitNameNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitSyncAtNotValid;

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
public class UnitSyncAt implements Serializable {

private java.time.Instant syncAt;

public UnitSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static UnitSyncAt create(java.time.Instant syncAt) {

	return new UnitSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitSyncAt that)) return false;
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
