package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;

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
public class CustomerFirstName implements Serializable {

private String firstName;

public CustomerFirstName(String firstName) {
this.firstName = firstName;
}

public static CustomerFirstName create(String firstName) {

	return new CustomerFirstName(firstName);
}

public String value() {
return this.firstName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerFirstName that)) return false;
return this.firstName.equals(that.firstName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(firstName);
}

@Override
public String toString() {
return String.valueOf(firstName);
}
}
