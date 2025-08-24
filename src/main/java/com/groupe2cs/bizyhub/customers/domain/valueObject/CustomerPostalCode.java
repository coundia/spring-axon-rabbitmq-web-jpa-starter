package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLocalIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLastNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFullNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceDebtNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerPhoneNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerEmailNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerNotesNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerStatusNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCompanyNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerAddressLine1NotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerAddressLine2NotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCityNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRegionNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCountryNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerPostalCodeNotValid;

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
public class CustomerPostalCode implements Serializable {

private String postalCode;

public CustomerPostalCode(String postalCode) {
this.postalCode = postalCode;
}

public static CustomerPostalCode create(String postalCode) {

	return new CustomerPostalCode(postalCode);
}

public String value() {
return this.postalCode;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerPostalCode that)) return false;
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
