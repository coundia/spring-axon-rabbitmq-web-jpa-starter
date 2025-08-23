package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLastNameNotValid;

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
public class CustomerLastName implements Serializable {

private String lastName;

public CustomerLastName(String lastName) {
this.lastName = lastName;
}

public static CustomerLastName create(String lastName) {

	return new CustomerLastName(lastName);
}

public String value() {
return this.lastName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerLastName that)) return false;
return this.lastName.equals(that.lastName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(lastName);
}

@Override
public String toString() {
return String.valueOf(lastName);
}
}
