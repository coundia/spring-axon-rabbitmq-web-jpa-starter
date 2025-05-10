package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAccountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleCategoryNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUpdatedAtNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleReferenceNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleCreatedByNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleTenantNotValid;

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
public class SaleTenant implements Serializable {

private String tenant;

public SaleTenant(String tenant) {
this.tenant = tenant;
}

public static SaleTenant create(String tenant) {

	return new SaleTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleTenant that)) return false;
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
