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
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyWebsiteNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyTaxIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCurrencyNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyAddressLine1NotValid;

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
public class CompanyAddressLine1 implements Serializable {

private String addressLine1;

public CompanyAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
}

public static CompanyAddressLine1 create(String addressLine1) {

	return new CompanyAddressLine1(addressLine1);
}

public String value() {
return this.addressLine1;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyAddressLine1 that)) return false;
return this.addressLine1.equals(that.addressLine1);
}

@Override
public int hashCode() {
return java.util.Objects.hash(addressLine1);
}

@Override
public String toString() {
return String.valueOf(addressLine1);
}
}
