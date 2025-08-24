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
public class CompanyCurrency implements Serializable {

private String currency;

public CompanyCurrency(String currency) {
this.currency = currency;
}

public static CompanyCurrency create(String currency) {

	return new CompanyCurrency(currency);
}

public String value() {
return this.currency;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyCurrency that)) return false;
return this.currency.equals(that.currency);
}

@Override
public int hashCode() {
return java.util.Objects.hash(currency);
}

@Override
public String toString() {
return String.valueOf(currency);
}
}
