package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleProductNotValid;

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
public class SaleProduct implements Serializable {

private String product;

public SaleProduct(String product) {
this.product = product;
}

public static SaleProduct create(String product) {

if (product == null || product.isBlank()) {
throw new SaleProductNotValid("Product is invalid");
}
return new SaleProduct(product);
}

public String value() {
return this.product;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleProduct that)) return false;
return this.product.equals(that.product);
}

@Override
public int hashCode() {
return java.util.Objects.hash(product);
}

@Override
public String toString() {
return String.valueOf(product);
}
}
