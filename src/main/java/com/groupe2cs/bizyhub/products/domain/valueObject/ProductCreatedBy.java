package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDetailsNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIsActiveNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUpdatedAtNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductReferenceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCreatedByNotValid;

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
public class ProductCreatedBy implements Serializable {

private String createdBy;

public ProductCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static ProductCreatedBy create(String createdBy) {

	return new ProductCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductCreatedBy that)) return false;
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
