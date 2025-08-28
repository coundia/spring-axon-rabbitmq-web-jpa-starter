package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLocalIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateAccountNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastSyncAtNotValid;

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
public class SyncStateLastSyncAt implements Serializable {

private java.time.Instant lastSyncAt;

public SyncStateLastSyncAt(java.time.Instant lastSyncAt) {
this.lastSyncAt = lastSyncAt;
}

public static SyncStateLastSyncAt create(java.time.Instant lastSyncAt) {

	return new SyncStateLastSyncAt(lastSyncAt);
}

public java.time.Instant value() {
return this.lastSyncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SyncStateLastSyncAt that)) return false;
return this.lastSyncAt.equals(that.lastSyncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(lastSyncAt);
}

@Override
public String toString() {
return String.valueOf(lastSyncAt);
}
}
