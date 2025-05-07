package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDetailsNotValid;

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
public class ProductDetails implements Serializable {

private String details;

public ProductDetails(String details) {
this.details = details;
}

public static ProductDetails create(String details) {

	return new ProductDetails(details);
}

public String value() {
return this.details;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductDetails that)) return false;
return this.details.equals(that.details);
}

@Override
public int hashCode() {
return java.util.Objects.hash(details);
}

@Override
public String toString() {
return String.valueOf(details);
}
}
