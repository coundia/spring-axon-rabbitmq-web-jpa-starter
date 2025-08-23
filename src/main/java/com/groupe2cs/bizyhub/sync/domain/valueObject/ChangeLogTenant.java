package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogPayloadNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogStatusNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAttemptsNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogErrorNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogCreatedByNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogTenantNotValid;

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
public class ChangeLogTenant implements Serializable {

private String tenant;

public ChangeLogTenant(String tenant) {
this.tenant = tenant;
}

public static ChangeLogTenant create(String tenant) {

	return new ChangeLogTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogTenant that)) return false;
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
