package com.groupe2cs.bizyhub.security.domain.exception;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;

public class UserNotFoundException extends RuntimeException {

public UserNotFoundException(String object, String value) {
super("User with "+object+": '" + value + "' not found");
}
}
