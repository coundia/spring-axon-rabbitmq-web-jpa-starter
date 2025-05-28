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
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerTenantNotValid;

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
public class FileManagerTenant implements Serializable {

private String tenant;

public FileManagerTenant(String tenant) {
this.tenant = tenant;
}

public static FileManagerTenant create(String tenant) {

	return new FileManagerTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof FileManagerTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
