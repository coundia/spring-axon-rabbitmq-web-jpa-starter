package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserTenantNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserTenant implements Serializable {

private String tenant;

public UserTenant(String tenant) {
this.tenant = tenant;
}

public static UserTenant create(String tenant) {
if (tenant == null || tenant.isBlank()) {
throw new UserTenantNotValid("Tenant is invalid");
}
return new UserTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserTenant that)) return false;
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
