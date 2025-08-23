package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogEntityIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogOperationNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.ChangeLogPayloadNotValid;

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
public class ChangeLogPayload implements Serializable {

private String payload;

public ChangeLogPayload(String payload) {
this.payload = payload;
}

public static ChangeLogPayload create(String payload) {

	return new ChangeLogPayload(payload);
}

public String value() {
return this.payload;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogPayload that)) return false;
return this.payload.equals(that.payload);
}

@Override
public int hashCode() {
return java.util.Objects.hash(payload);
}

@Override
public String toString() {
return String.valueOf(payload);
}
}
