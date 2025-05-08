package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSaleNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUserNotValid;

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
public class SaleUserUser implements Serializable {

private String user;

public SaleUserUser(String user) {
this.user = user;
}

public static SaleUserUser create(String user) {

	return new SaleUserUser(user);
}

public String value() {
return this.user;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserUser that)) return false;
return this.user.equals(that.user);
}

@Override
public int hashCode() {
return java.util.Objects.hash(user);
}

@Override
public String toString() {
return String.valueOf(user);
}
}
