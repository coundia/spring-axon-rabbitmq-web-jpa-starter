package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTokenNotValid;

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
public class RefreshTokenToken implements Serializable {

private String token;

public RefreshTokenToken(String token) {
this.token = token;
}

public static RefreshTokenToken create(String token) {

if (token == null || token.isBlank()) {
throw new RefreshTokenTokenNotValid("Token is invalid");
}
return new RefreshTokenToken(token);
}

public String value() {
return this.token;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof RefreshTokenToken that)) return false;
return this.token.equals(that.token);
}

@Override
public int hashCode() {
return java.util.Objects.hash(token);
}

@Override
public String toString() {
return String.valueOf(token);
}
}
