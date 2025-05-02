package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionPermissionNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionTenantNotValid;

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
public class RolePermissionTenant implements Serializable {

private String tenant;

public RolePermissionTenant(String tenant) {
this.tenant = tenant;
}

public static RolePermissionTenant create(String tenant) {

	return new RolePermissionTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof RolePermissionTenant that)) return false;
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
