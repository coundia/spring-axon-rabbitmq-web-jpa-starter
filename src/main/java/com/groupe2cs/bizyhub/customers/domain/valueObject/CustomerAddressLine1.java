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
public class CustomerAddressLine1 implements Serializable {

private String addressLine1;

public CustomerAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
}

public static CustomerAddressLine1 create(String addressLine1) {

	return new CustomerAddressLine1(addressLine1);
}

public String value() {
return this.addressLine1;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerAddressLine1 that)) return false;
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
