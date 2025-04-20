package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionRoleNotValid;

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
public class RolePermissionRole implements Serializable {

private String role;

public RolePermissionRole(String role) {
this.role = role;
}

public static RolePermissionRole create(String role) {
if (role == null || role.isBlank()) {
throw new RolePermissionRoleNotValid("Role is invalid");
}
return new RolePermissionRole(role);
}

public String value() {
return this.role;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof RolePermissionRole that)) return false;
return this.role.equals(that.role);
}

@Override
public int hashCode() {
return java.util.Objects.hash(role);
}

@Override
public String toString() {
return String.valueOf(role);
}
}
