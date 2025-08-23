package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;

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
public class ChangeLogEntityId implements Serializable {

private String entityId;

public ChangeLogEntityId(String entityId) {
this.entityId = entityId;
}

public static ChangeLogEntityId create(String entityId) {

if (entityId == null || entityId.isBlank()) {
throw new ChangeLogEntityIdNotValid("EntityId is invalid");
}
return new ChangeLogEntityId(entityId);
}

public String value() {
return this.entityId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogEntityId that)) return false;
return this.entityId.equals(that.entityId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(entityId);
}

@Override
public String toString() {
return String.valueOf(entityId);
}
}
