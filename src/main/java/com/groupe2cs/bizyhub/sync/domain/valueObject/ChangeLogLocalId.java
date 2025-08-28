package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogAccountNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogLocalIdNotValid;

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
public class ChangeLogLocalId implements Serializable {

private String localId;

public ChangeLogLocalId(String localId) {
this.localId = localId;
}

public static ChangeLogLocalId create(String localId) {

	return new ChangeLogLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
