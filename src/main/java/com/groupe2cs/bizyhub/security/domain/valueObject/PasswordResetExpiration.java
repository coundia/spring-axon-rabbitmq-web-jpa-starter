package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetExpirationNotValid;

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
public class PasswordResetExpiration implements Serializable {

private java.time.Instant expiration;

public PasswordResetExpiration(java.time.Instant expiration) {
this.expiration = expiration;
}

public static PasswordResetExpiration create(java.time.Instant expiration) {
if (expiration == null) {
throw new PasswordResetExpirationNotValid("Expiration is invalid");
}
return new PasswordResetExpiration(expiration);
}

public java.time.Instant value() {
return this.expiration;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof PasswordResetExpiration that)) return false;
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
