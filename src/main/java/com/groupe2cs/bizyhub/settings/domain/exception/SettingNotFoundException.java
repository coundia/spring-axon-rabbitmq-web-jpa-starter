package com.groupe2cs.bizyhub.settings.domain.exception;

import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingId;

public class SettingNotFoundException extends RuntimeException {

public SettingNotFoundException(String object, String value) {
super("Setting with "+object+": '" + value + "' not found");
}
}
