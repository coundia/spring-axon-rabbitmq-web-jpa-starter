package com.groupe2cs.bizyhub.sync.domain.exception;

import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;

public class ChangeLogNotFoundException extends RuntimeException {

public ChangeLogNotFoundException(String object, String value) {
super("ChangeLog with "+object+": '" + value + "' not found");
}
}
