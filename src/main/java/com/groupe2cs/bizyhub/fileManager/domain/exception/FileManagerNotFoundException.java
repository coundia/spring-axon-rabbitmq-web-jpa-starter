package com.groupe2cs.bizyhub.fileManager.domain.exception;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerId;

public class FileManagerNotFoundException extends RuntimeException {

public FileManagerNotFoundException(String object, String value) {
super("FileManager with "+object+": '" + value + "' not found");
}
}
