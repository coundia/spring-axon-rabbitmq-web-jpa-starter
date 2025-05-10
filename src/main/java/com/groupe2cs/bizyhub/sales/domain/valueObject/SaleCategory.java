package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAccountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleCategoryNotValid;

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
public class SaleCategory implements Serializable {

private String category;

public SaleCategory(String category) {
this.category = category;
}

public static SaleCategory create(String category) {

	return new SaleCategory(category);
}

public String value() {
return this.category;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleCategory that)) return false;
return this.category.equals(that.category);
}

@Override
public int hashCode() {
return java.util.Objects.hash(category);
}

@Override
public String toString() {
return String.valueOf(category);
}
}
