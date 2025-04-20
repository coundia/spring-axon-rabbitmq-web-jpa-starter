package com.groupe2cs.bizyhub.security.domain.exception;

import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;

public class RolePermissionNotFoundException extends RuntimeException {

public RolePermissionNotFoundException(String object, String value) {
super("RolePermission with "+object+": '" + value + "' not found");
}
}
