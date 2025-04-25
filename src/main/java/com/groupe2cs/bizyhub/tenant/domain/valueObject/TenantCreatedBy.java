package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantLanguageNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantActiveNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantCreatedByNotValid;

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
public class TenantCreatedBy implements Serializable {

private String createdBy;

public TenantCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static TenantCreatedBy create(String createdBy) {
if (createdBy == null || createdBy.isBlank()) {
throw new TenantCreatedByNotValid("CreatedBy is invalid");
}
return new TenantCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TenantCreatedBy that)) return false;
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
