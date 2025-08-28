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
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRegionNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCountryNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerPostalCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerSyncAtNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIsActiveNotValid;

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
public class CustomerIsActive implements Serializable {

private Boolean isActive;

public CustomerIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static CustomerIsActive create(Boolean isActive) {

	return new CustomerIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerIsActive that)) return false;
return this.isActive.equals(that.isActive);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isActive);
}

@Override
public String toString() {
return String.valueOf(isActive);
}
}
