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
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerAccountNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCompanyNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerAddressLine1NotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerAddressLine2NotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCityNotValid;

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
public class CustomerCity implements Serializable {

private String city;

public CustomerCity(String city) {
this.city = city;
}

public static CustomerCity create(String city) {

	return new CustomerCity(city);
}

public String value() {
return this.city;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerCity that)) return false;
return this.city.equals(that.city);
}

@Override
public int hashCode() {
return java.util.Objects.hash(city);
}

@Override
public String toString() {
return String.valueOf(city);
}
}
