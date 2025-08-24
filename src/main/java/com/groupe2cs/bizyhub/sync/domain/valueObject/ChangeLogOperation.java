package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;

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
public class ChangeLogOperation implements Serializable {

private String operation;

public ChangeLogOperation(String operation) {
this.operation = operation;
}

public static ChangeLogOperation create(String operation) {

	return new ChangeLogOperation(operation);
}

public String value() {
return this.operation;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogOperation that)) return false;
return this.operation.equals(that.operation);
}

@Override
public int hashCode() {
return java.util.Objects.hash(operation);
}

@Override
public String toString() {
return String.valueOf(operation);
}
}
