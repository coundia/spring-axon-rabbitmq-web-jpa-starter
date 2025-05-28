package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerOriginalNameNotValid;

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
public class FileManagerOriginalName implements Serializable {

private String originalName;

public FileManagerOriginalName(String originalName) {
this.originalName = originalName;
}

public static FileManagerOriginalName create(String originalName) {

	return new FileManagerOriginalName(originalName);
}

public String value() {
return this.originalName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof FileManagerOriginalName that)) return false;
return this.originalName.equals(that.originalName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(originalName);
}

@Override
public String toString() {
return String.valueOf(originalName);
}
}
