package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;

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
public class UserUsername implements Serializable {

private String username;

public UserUsername(String username) {
this.username = username;
}

public static UserUsername create(String username) {
if (username == null || username.isBlank()) {
throw new UserUsernameNotValid("Username is invalid");
}
return new UserUsername(username);
}

public String value() {
return this.username;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserUsername that)) return false;
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
