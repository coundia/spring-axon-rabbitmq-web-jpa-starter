package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;

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
public class VerificationCodeUsername implements Serializable {

private String username;

public VerificationCodeUsername(String username) {
this.username = username;
}

public static VerificationCodeUsername create(String username) {

	return new VerificationCodeUsername(username);
}

public String value() {
return this.username;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeUsername that)) return false;
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
