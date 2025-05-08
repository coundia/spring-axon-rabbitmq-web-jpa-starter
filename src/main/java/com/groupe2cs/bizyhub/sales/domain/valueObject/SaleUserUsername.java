package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSaleNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUserNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsernameNotValid;

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
public class SaleUserUsername implements Serializable {

private String username;

public SaleUserUsername(String username) {
this.username = username;
}

public static SaleUserUsername create(String username) {

	return new SaleUserUsername(username);
}

public String value() {
return this.username;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserUsername that)) return false;
return this.username.equals(that.username);
}

@Override
public int hashCode() {
return java.util.Objects.hash(username);
}

@Override
public String toString() {
return String.valueOf(username);
}
}
