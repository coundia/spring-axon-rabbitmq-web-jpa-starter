package com.groupe2cs.bizyhub.security.domain.exception;

import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;

public class PermissionNotFoundException extends RuntimeException {

public PermissionNotFoundException(String object, String value) {
super("Permission with "+object+": '" + value + "' not found");
}
}
