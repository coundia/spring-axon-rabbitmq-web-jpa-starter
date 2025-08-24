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
import com.groupe2cs.bizyhub.units.domain.exception.UnitTenantNotValid;

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
public class UnitTenant implements Serializable {

private String tenant;

public UnitTenant(String tenant) {
this.tenant = tenant;
}

public static UnitTenant create(String tenant) {

	return new UnitTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
