package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAccountNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogLocalIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogPayloadNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogStatusNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAttemptsNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogErrorNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogCreatedByNotValid;

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
public class ChangeLogCreatedBy implements Serializable {

private String createdBy;

public ChangeLogCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static ChangeLogCreatedBy create(String createdBy) {

	return new ChangeLogCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogCreatedBy that)) return false;
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
