package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetUsernameNotValid;

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
public class PasswordResetUsername implements Serializable {

private String username;

public PasswordResetUsername(String username) {
this.username = username;
}

public static PasswordResetUsername create(String username) {
if (username == null || username.isBlank()) {
throw new PasswordResetUsernameNotValid("Username is invalid");
}
return new PasswordResetUsername(username);
}

public String value() {
return this.username;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof PasswordResetUsername that)) return false;
return this.username.equals(that.username);
}

@Override
public int hashCode() {
return java.util.Objects.hash(username);
}

@Override
public String toString() {
return String.valueOf(username);
}
}
