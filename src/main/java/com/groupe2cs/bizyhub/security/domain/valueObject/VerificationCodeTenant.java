package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeEmailNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeCodeNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeStatusNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeSourceNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTenantNotValid;

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
public class VerificationCodeTenant implements Serializable {

private String tenant;

public VerificationCodeTenant(String tenant) {
this.tenant = tenant;
}

public static VerificationCodeTenant create(String tenant) {

	return new VerificationCodeTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
