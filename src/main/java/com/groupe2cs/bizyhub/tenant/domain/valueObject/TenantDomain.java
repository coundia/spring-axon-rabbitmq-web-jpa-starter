package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;

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
public class TenantDomain implements Serializable {

private String domain;

public TenantDomain(String domain) {
this.domain = domain;
}

public static TenantDomain create(String domain) {
if (domain == null || domain.isBlank()) {
throw new TenantDomainNotValid("Domain is invalid");
}
return new TenantDomain(domain);
}

public String value() {
return this.domain;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TenantDomain that)) return false;
return this.domain.equals(that.domain);
}

@Override
public int hashCode() {
return java.util.Objects.hash(domain);
}

@Override
public String toString() {
return String.valueOf(domain);
}
}
