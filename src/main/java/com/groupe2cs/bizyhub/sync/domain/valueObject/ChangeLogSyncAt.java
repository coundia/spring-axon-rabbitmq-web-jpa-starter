package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogPayloadNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogStatusNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogSyncAtNotValid;

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
public class ChangeLogSyncAt implements Serializable {

private java.time.Instant syncAt;

public ChangeLogSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static ChangeLogSyncAt create(java.time.Instant syncAt) {

	return new ChangeLogSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
