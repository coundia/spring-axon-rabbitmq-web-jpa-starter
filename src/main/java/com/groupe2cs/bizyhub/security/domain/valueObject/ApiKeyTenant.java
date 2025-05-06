package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyAppKeyNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyActiveNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedAtNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyTenantNotValid;

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
public class ApiKeyTenant implements Serializable {

private String tenant;

public ApiKeyTenant(String tenant) {
this.tenant = tenant;
}

public static ApiKeyTenant create(String tenant) {

	return new ApiKeyTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ApiKeyTenant that)) return false;
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
