package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyAppKeyNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedAtNotValid;

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
public class ApiKeyCreatedAt implements Serializable {

private java.time.Instant createdAt;

public ApiKeyCreatedAt(java.time.Instant createdAt) {
this.createdAt = createdAt;
}

public static ApiKeyCreatedAt create(java.time.Instant createdAt) {
if (createdAt == null) {
throw new ApiKeyCreatedAtNotValid("CreatedAt is invalid");
}
return new ApiKeyCreatedAt(createdAt);
}

public java.time.Instant value() {
return this.createdAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ApiKeyCreatedAt that)) return false;
return this.createdAt.equals(that.createdAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdAt);
}

@Override
public String toString() {
return String.valueOf(createdAt);
}
}
