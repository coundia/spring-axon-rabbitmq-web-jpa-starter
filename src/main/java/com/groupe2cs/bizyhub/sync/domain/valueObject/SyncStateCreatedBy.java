package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLocalIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastCursorNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateCreatedByNotValid;

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
public class SyncStateCreatedBy implements Serializable {

private String createdBy;

public SyncStateCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static SyncStateCreatedBy create(String createdBy) {

	return new SyncStateCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SyncStateCreatedBy that)) return false;
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
