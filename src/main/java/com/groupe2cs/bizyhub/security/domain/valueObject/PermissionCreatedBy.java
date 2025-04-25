package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionCreatedByNotValid;

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
public class PermissionCreatedBy implements Serializable {

private String createdBy;

public PermissionCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static PermissionCreatedBy create(String createdBy) {
if (createdBy == null || createdBy.isBlank()) {
throw new PermissionCreatedByNotValid("CreatedBy is invalid");
}
return new PermissionCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof PermissionCreatedBy that)) return false;
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
