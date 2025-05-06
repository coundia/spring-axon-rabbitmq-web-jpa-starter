package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsersNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsernameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserEmailNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIsActiveNotValid;

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
public class SaleUserIsActive implements Serializable {

private Boolean isActive;

public SaleUserIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static SaleUserIsActive create(Boolean isActive) {

if (isActive == null) {
throw new SaleUserIsActiveNotValid("IsActive is invalid");
}
return new SaleUserIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserIsActive that)) return false;
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
