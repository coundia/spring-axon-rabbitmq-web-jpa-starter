package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleUserNotValid;

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
public class UserRoleUser implements Serializable {

private String user;

public UserRoleUser(String user) {
this.user = user;
}

public static UserRoleUser create(String user) {
if (user == null || user.isBlank()) {
throw new UserRoleUserNotValid("User is invalid");
}
return new UserRoleUser(user);
}

public String value() {
return this.user;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserRoleUser that)) return false;
return this.user.equals(that.user);
}

@Override
public int hashCode() {
return java.util.Objects.hash(user);
}

@Override
public String toString() {
return String.valueOf(user);
}
}
