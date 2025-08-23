package com.groupe2cs.bizyhub.units.domain.exception;

import com.groupe2cs.bizyhub.units.domain.valueObject.UnitId;

public class UnitNotFoundException extends RuntimeException {

public UnitNotFoundException(String object, String value) {
super("Unit with "+object+": '" + value + "' not found");
}
}
