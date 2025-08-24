package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastCursorNotValid;

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
public class SyncStateLastCursor implements Serializable {

private String lastCursor;

public SyncStateLastCursor(String lastCursor) {
this.lastCursor = lastCursor;
}

public static SyncStateLastCursor create(String lastCursor) {

	return new SyncStateLastCursor(lastCursor);
}

public String value() {
return this.lastCursor;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SyncStateLastCursor that)) return false;
return this.lastCursor.equals(that.lastCursor);
}

@Override
public int hashCode() {
return java.util.Objects.hash(lastCursor);
}

@Override
public String toString() {
return String.valueOf(lastCursor);
}
}
