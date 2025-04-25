package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantLanguageNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantActiveNotValid;

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
public class TenantActive implements Serializable {

private Boolean active;

public TenantActive(Boolean active) {
this.active = active;
}

public static TenantActive create(Boolean active) {
if (active == null) {
throw new TenantActiveNotValid("Active is invalid");
}
return new TenantActive(active);
}

public Boolean value() {
return this.active;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TenantActive that)) return false;
return this.active.equals(that.active);
}

@Override
public int hashCode() {
return java.util.Objects.hash(active);
}

@Override
public String toString() {
return String.valueOf(active);
}
}
