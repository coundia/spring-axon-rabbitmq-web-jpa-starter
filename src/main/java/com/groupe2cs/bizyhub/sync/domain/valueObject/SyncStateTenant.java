package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLocalIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateAccountNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLastCursorNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateCreatedByNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateTenantNotValid;

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
public class SyncStateTenant implements Serializable {

private String tenant;

public SyncStateTenant(String tenant) {
this.tenant = tenant;
}

public static SyncStateTenant create(String tenant) {

	return new SyncStateTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SyncStateTenant that)) return false;
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
