package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsersNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsernameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUpdatedAtNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserReferenceNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserCreatedByNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserTenantNotValid;

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
public class SaleUserTenant implements Serializable {

private String tenant;

public SaleUserTenant(String tenant) {
this.tenant = tenant;
}

public static SaleUserTenant create(String tenant) {

	return new SaleUserTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
