package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodePhoneNotValid;

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
public class VerificationCodePhone implements Serializable {

private String phone;

public VerificationCodePhone(String phone) {
this.phone = phone;
}

public static VerificationCodePhone create(String phone) {

	return new VerificationCodePhone(phone);
}

public String value() {
return this.phone;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodePhone that)) return false;
return this.phone.equals(that.phone);
}

@Override
public int hashCode() {
return java.util.Objects.hash(phone);
}

@Override
public String toString() {
return String.valueOf(phone);
}
}
