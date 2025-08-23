package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;

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
public class CustomerCode implements Serializable {

private String code;

public CustomerCode(String code) {
this.code = code;
}

public static CustomerCode create(String code) {

	return new CustomerCode(code);
}

public String value() {
return this.code;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerCode that)) return false;
return this.code.equals(that.code);
}

@Override
public int hashCode() {
return java.util.Objects.hash(code);
}

@Override
public String toString() {
return String.valueOf(code);
}
}
