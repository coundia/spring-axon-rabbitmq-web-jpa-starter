package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;

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
public class UserPassword implements Serializable {

private String password;

public UserPassword(String password) {
this.password = password;
}

public static UserPassword create(String password) {

if (password == null || password.isBlank()) {
throw new UserPasswordNotValid("Password is invalid");
}
return new UserPassword(password);
}

public String value() {
return this.password;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserPassword that)) return false;
return this.password.equals(that.password);
}

@Override
public int hashCode() {
return java.util.Objects.hash(password);
}

@Override
public String toString() {
return String.valueOf(password);
}
}
