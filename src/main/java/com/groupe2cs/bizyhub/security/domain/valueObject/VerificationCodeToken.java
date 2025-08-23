package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeNotesNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;

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
public class VerificationCodeToken implements Serializable {

private String token;

public VerificationCodeToken(String token) {
this.token = token;
}

public static VerificationCodeToken create(String token) {

	return new VerificationCodeToken(token);
}

public String value() {
return this.token;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeToken that)) return false;
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
