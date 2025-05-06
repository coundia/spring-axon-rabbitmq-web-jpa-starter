package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;

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
public class SaleIsActive implements Serializable {

private Boolean isActive;

public SaleIsActive(Boolean isActive) {
this.isActive = isActive;
}

public static SaleIsActive create(Boolean isActive) {

if (isActive == null) {
throw new SaleIsActiveNotValid("IsActive is invalid");
}
return new SaleIsActive(isActive);
}

public Boolean value() {
return this.isActive;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleIsActive that)) return false;
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
