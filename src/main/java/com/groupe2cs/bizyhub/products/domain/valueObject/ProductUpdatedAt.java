package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDetailsNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIsActiveNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUpdatedAtNotValid;

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
public class ProductUpdatedAt implements Serializable {

private java.time.Instant updatedAt;

public ProductUpdatedAt(java.time.Instant updatedAt) {
this.updatedAt = updatedAt;
}

public static ProductUpdatedAt create(java.time.Instant updatedAt) {

	return new ProductUpdatedAt(updatedAt);
}

public java.time.Instant value() {
return this.updatedAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductUpdatedAt that)) return false;
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
