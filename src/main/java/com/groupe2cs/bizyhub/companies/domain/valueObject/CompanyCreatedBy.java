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
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyAddressLine2NotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCityNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRegionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCountryNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyAccountNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPostalCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIsActiveNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanySyncAtNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIsDefaultNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCreatedByNotValid;

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
public class CompanyCreatedBy implements Serializable {

private String createdBy;

public CompanyCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static CompanyCreatedBy create(String createdBy) {

	return new CompanyCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyCreatedBy that)) return false;
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
