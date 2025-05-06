package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantLanguageNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantActiveNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantTenantNotValid;

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
public class TenantTenant implements Serializable {

private String tenant;

public TenantTenant(String tenant) {
this.tenant = tenant;
}

public static TenantTenant create(String tenant) {

	return new TenantTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TenantTenant that)) return false;
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
