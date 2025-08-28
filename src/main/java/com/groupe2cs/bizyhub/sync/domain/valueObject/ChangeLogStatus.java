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
public class ChangeLogStatus implements Serializable {

private String status;

public ChangeLogStatus(String status) {
this.status = status;
}

public static ChangeLogStatus create(String status) {

	return new ChangeLogStatus(status);
}

public String value() {
return this.status;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogStatus that)) return false;
return this.status.equals(that.status);
}

@Override
public int hashCode() {
return java.util.Objects.hash(status);
}

@Override
public String toString() {
return String.valueOf(status);
}
}
