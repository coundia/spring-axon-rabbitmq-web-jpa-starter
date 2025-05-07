package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsersNotValid;

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
public class SaleUserUsers implements Serializable {

private String users;

public SaleUserUsers(String users) {
this.users = users;
}

public static SaleUserUsers create(String users) {

	return new SaleUserUsers(users);
}

public String value() {
return this.users;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserUsers that)) return false;
return this.users.equals(that.users);
}

@Override
public int hashCode() {
return java.util.Objects.hash(users);
}

@Override
public String toString() {
return String.valueOf(users);
}
}
