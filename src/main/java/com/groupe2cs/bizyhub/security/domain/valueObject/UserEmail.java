package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserEmailNotValid;

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
public class UserEmail implements Serializable {

private String email;

public UserEmail(String email) {
this.email = email;
}

public static UserEmail create(String email) {
if (email == null || email.isBlank()) {
throw new UserEmailNotValid("Email is invalid");
}
return new UserEmail(email);
}

public String value() {
return this.email;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UserEmail that)) return false;
return this.email.equals(that.email);
}

@Override
public int hashCode() {
return java.util.Objects.hash(email);
}

@Override
public String toString() {
return String.valueOf(email);
}
}
