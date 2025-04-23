package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyKeyNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedAtNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyExpirationNotValid;

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
public class ApiKeyExpiration implements Serializable {

private java.time.Instant expiration;

public ApiKeyExpiration(java.time.Instant expiration) {
this.expiration = expiration;
}

public static ApiKeyExpiration create(java.time.Instant expiration) {
if (expiration == null) {
throw new ApiKeyExpirationNotValid("Expiration is invalid");
}
return new ApiKeyExpiration(expiration);
}

public java.time.Instant value() {
return this.expiration;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ApiKeyExpiration that)) return false;
return this.expiration.equals(that.expiration);
}

@Override
public int hashCode() {
return java.util.Objects.hash(expiration);
}

@Override
public String toString() {
return String.valueOf(expiration);
}
}
