package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyNameNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyDescriptionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPhoneNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyEmailNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyWebsiteNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyTaxIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCurrencyNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyAddressLine1NotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyAddressLine2NotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCityNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRegionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCountryNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPostalCodeNotValid;

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
public class CompanyPostalCode implements Serializable {

private String postalCode;

public CompanyPostalCode(String postalCode) {
this.postalCode = postalCode;
}

public static CompanyPostalCode create(String postalCode) {

	return new CompanyPostalCode(postalCode);
}

public String value() {
return this.postalCode;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyPostalCode that)) return false;
return this.postalCode.equals(that.postalCode);
}

@Override
public int hashCode() {
return java.util.Objects.hash(postalCode);
}

@Override
public String toString() {
return String.valueOf(postalCode);
}
}
