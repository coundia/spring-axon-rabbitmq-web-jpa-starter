package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLastNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFullNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceNotValid;

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
public class CustomerBalance implements Serializable {

private Double balance;

public CustomerBalance(Double balance) {
this.balance = balance;
}

public static CustomerBalance create(Double balance) {

if (balance == null) {
throw new CustomerBalanceNotValid("Balance is invalid");
}
return new CustomerBalance(balance);
}

public Double value() {
return this.balance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerBalance that)) return false;
return this.balance.equals(that.balance);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balance);
}

@Override
public String toString() {
return String.valueOf(balance);
}
}
