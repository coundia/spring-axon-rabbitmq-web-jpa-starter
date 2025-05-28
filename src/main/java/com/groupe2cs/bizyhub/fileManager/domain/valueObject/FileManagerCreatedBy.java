package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerOriginalNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerMimeTypeNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerSizeNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerPathNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerUriNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIsPublicNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerCreatedByNotValid;

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
public class FileManagerCreatedBy implements Serializable {

private String createdBy;

public FileManagerCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static FileManagerCreatedBy create(String createdBy) {

	return new FileManagerCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof FileManagerCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
