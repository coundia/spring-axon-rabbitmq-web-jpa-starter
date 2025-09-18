package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeNotesNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodePhoneNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeEmailNotValid;

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
public class VerificationCodeEmail implements Serializable {

private String email;

public VerificationCodeEmail(String email) {
this.email = email;
}

public static VerificationCodeEmail create(String email) {

	return new VerificationCodeEmail(email);
}

public String value() {
return this.email;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeEmail that)) return false;
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
