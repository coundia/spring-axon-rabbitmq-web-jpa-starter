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
public class ChangeLogAttempts implements Serializable {

private Integer attempts;

public ChangeLogAttempts(Integer attempts) {
this.attempts = attempts;
}

public static ChangeLogAttempts create(Integer attempts) {

if (attempts < 0) {
throw new ChangeLogAttemptsNotValid("Attempts is invalid");
}
return new ChangeLogAttempts(attempts);
}

public Integer value() {
return this.attempts;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChangeLogAttempts that)) return false;
return this.attempts.equals(that.attempts);
}

@Override
public int hashCode() {
return java.util.Objects.hash(attempts);
}

@Override
public String toString() {
return String.valueOf(attempts);
}
}
