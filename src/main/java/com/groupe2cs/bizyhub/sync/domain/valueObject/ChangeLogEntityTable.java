package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;

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
public class ChangeLogEntityTable implements Serializable {

private String entityTable;

public ChangeLogEntityTable(String entityTable) {
this.entityTable = entityTable;
}

public static ChangeLogEntityTable create(String entityTable) {

if (entityTable == null || entityTable.isBlank()) {
throw new ChangeLogEntityTableNotValid("EntityTable is invalid");
}
return new ChangeLogEntityTable(entityTable);
}

public String value() {
return this.entityTable;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogEntityTable that)) return false;
return this.entityTable.equals(that.entityTable);
}

@Override
public int hashCode() {
return java.util.Objects.hash(entityTable);
}

@Override
public String toString() {
return String.valueOf(entityTable);
}
}
