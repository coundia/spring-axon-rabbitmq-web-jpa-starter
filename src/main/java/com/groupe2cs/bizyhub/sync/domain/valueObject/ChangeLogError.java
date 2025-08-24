package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogPayloadNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogStatusNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogSyncAtNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAttemptsNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogErrorNotValid;

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
public class ChangeLogError implements Serializable {

private String error;

public ChangeLogError(String error) {
this.error = error;
}

public static ChangeLogError create(String error) {

	return new ChangeLogError(error);
}

public String value() {
return this.error;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogError that)) return false;
return this.error.equals(that.error);
}

@Override
public int hashCode() {
return java.util.Objects.hash(error);
}

@Override
public String toString() {
return String.valueOf(error);
}
}
