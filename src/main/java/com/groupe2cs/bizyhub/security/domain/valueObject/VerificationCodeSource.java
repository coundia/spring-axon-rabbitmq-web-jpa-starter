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
public class VerificationCodeSource implements Serializable {

private String source;

public VerificationCodeSource(String source) {
this.source = source;
}

public static VerificationCodeSource create(String source) {

	return new VerificationCodeSource(source);
}

public String value() {
return this.source;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeSource that)) return false;
return this.source.equals(that.source);
}

@Override
public int hashCode() {
return java.util.Objects.hash(source);
}

@Override
public String toString() {
return String.valueOf(source);
}
}
