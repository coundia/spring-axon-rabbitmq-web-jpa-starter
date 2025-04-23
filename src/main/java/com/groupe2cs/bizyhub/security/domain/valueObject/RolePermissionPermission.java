package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionPermissionNotValid;

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
public class RolePermissionPermission implements Serializable {

private String permission;

public RolePermissionPermission(String permission) {
this.permission = permission;
}

public static RolePermissionPermission create(String permission) {
if (permission == null || permission.isBlank()) {
throw new RolePermissionPermissionNotValid("Permission is invalid");
}
return new RolePermissionPermission(permission);
}

public String value() {
return this.permission;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof RolePermissionPermission that)) return false;
return this.permission.equals(that.permission);
}

@Override
public int hashCode() {
return java.util.Objects.hash(permission);
}

@Override
public String toString() {
return String.valueOf(permission);
}
}
