package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetCreatedByNotValid;

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
public class PasswordResetCreatedBy implements Serializable {

private String createdBy;

public PasswordResetCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static PasswordResetCreatedBy create(String createdBy) {

	return new PasswordResetCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof PasswordResetCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
