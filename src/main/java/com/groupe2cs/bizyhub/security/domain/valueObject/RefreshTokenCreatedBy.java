package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenCreatedByNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RefreshTokenCreatedBy implements Serializable {

private String createdBy;

public RefreshTokenCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static RefreshTokenCreatedBy create(String createdBy) {
if (createdBy == null || createdBy.isBlank()) {
throw new RefreshTokenCreatedByNotValid("CreatedBy is invalid");
}
return new RefreshTokenCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof RefreshTokenCreatedBy that)) return false;
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
