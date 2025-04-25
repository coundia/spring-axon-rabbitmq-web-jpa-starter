package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;

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
public class TenantDescription implements Serializable {

private String description;

public TenantDescription(String description) {
this.description = description;
}

public static TenantDescription create(String description) {
if (description == null || description.isBlank()) {
throw new TenantDescriptionNotValid("Description is invalid");
}
return new TenantDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TenantDescription that)) return false;
return this.description.equals(that.description);
}

@Override
public int hashCode() {
return java.util.Objects.hash(description);
}

@Override
public String toString() {
return String.valueOf(description);
}
}
