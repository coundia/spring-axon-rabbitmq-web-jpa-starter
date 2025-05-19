package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserFirstNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserLastNameNotValid;

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
public class UserLastName implements Serializable {

private String lastName;

public UserLastName(String lastName) {
this.lastName = lastName;
}

public static UserLastName create(String lastName) {

	return new UserLastName(lastName);
}

public String value() {
return this.lastName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserLastName that)) return false;
return this.lastName.equals(that.lastName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(lastName);
}

@Override
public String toString() {
return String.valueOf(lastName);
}
}
