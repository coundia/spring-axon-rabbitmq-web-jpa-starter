package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsersNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsernameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserEmailNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUpdatedAtNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserReferenceNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserCreatedByNotValid;

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
public class SaleUserCreatedBy implements Serializable {

private String createdBy;

public SaleUserCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static SaleUserCreatedBy create(String createdBy) {

	return new SaleUserCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
