package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyLocalIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyNameNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyDescriptionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPhoneNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyEmailNotValid;

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
public class CompanyEmail implements Serializable {

private String email;

public CompanyEmail(String email) {
this.email = email;
}

public static CompanyEmail create(String email) {

	return new CompanyEmail(email);
}

public String value() {
return this.email;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyEmail that)) return false;
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
