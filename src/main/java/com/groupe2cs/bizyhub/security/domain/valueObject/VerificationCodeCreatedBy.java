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
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeSourceNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeCreatedByNotValid;

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
public class VerificationCodeCreatedBy implements Serializable {

private String createdBy;

public VerificationCodeCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static VerificationCodeCreatedBy create(String createdBy) {

	return new VerificationCodeCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
