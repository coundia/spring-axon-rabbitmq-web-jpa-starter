package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserFirstNameNotValid;

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
public class UserFirstName implements Serializable {

private String firstName;

public UserFirstName(String firstName) {
this.firstName = firstName;
}

public static UserFirstName create(String firstName) {

	return new UserFirstName(firstName);
}

public String value() {
return this.firstName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserFirstName that)) return false;
return this.firstName.equals(that.firstName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(firstName);
}

@Override
public String toString() {
return String.valueOf(firstName);
}
}
