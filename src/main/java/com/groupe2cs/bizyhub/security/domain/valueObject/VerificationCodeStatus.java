package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeNotesNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodePhoneNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeEmailNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeCodeNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeStatusNotValid;

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
public class VerificationCodeStatus implements Serializable {

private String status;

public VerificationCodeStatus(String status) {
this.status = status;
}

public static VerificationCodeStatus create(String status) {

	return new VerificationCodeStatus(status);
}

public String value() {
return this.status;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeStatus that)) return false;
return this.status.equals(that.status);
}

@Override
public int hashCode() {
return java.util.Objects.hash(status);
}

@Override
public String toString() {
return String.valueOf(status);
}
}
