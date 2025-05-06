package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUsersNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserUpdatedAtNotValid;

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
public class SaleUserUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public SaleUserUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static SaleUserUpdatedAt create(java.time.Instant updatedAt) {

	return new SaleUserUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserUpdatedAt that)) return false;
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
