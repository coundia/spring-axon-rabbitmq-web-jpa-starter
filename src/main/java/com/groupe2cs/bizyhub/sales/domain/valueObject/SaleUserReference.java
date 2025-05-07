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
public class SaleUserReference implements Serializable {

private String reference;

public SaleUserReference(String reference) {
this.reference = reference;
}

public static SaleUserReference create(String reference) {

	return new SaleUserReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
