package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectNameNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class FileManagerObjectName implements Serializable {

private String objectName;

public FileManagerObjectName(String objectName) {
this.objectName = objectName;
}

public static FileManagerObjectName create(String objectName) {

	return new FileManagerObjectName(objectName);
}

public String value() {
return this.objectName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof FileManagerObjectName that)) return false;
return this.objectName.equals(that.objectName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(objectName);
}

@Override
public String toString() {
return String.valueOf(objectName);
}
}
