package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUpdatedAtNotValid;

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
public class SaleUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public SaleUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static SaleUpdatedAt create(java.time.Instant updatedAt) {

	return new SaleUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUpdatedAt that)) return false;
return this.updatedAt.equals(that.updatedAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(updatedAt);
}

@Override
public String toString() {
return String.valueOf(updatedAt);
}
}
