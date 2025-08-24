package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLocalIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLastNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFullNameNotValid;

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
public class CustomerFullName implements Serializable {

private String fullName;

public CustomerFullName(String fullName) {
this.fullName = fullName;
}

public static CustomerFullName create(String fullName) {

	return new CustomerFullName(fullName);
}

public String value() {
return this.fullName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerFullName that)) return false;
return this.fullName.equals(that.fullName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(fullName);
}

@Override
public String toString() {
return String.valueOf(fullName);
}
}
