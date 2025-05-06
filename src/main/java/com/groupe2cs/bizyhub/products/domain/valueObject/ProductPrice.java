package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;

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
public class ProductPrice implements Serializable {

private Double price;

public ProductPrice(Double price) {
this.price = price;
}

public static ProductPrice create(Double price) {

	return new ProductPrice(price);
}

public Double value() {
return this.price;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductPrice that)) return false;
return this.price.equals(that.price);
}

@Override
public int hashCode() {
return java.util.Objects.hash(price);
}

@Override
public String toString() {
return String.valueOf(price);
}
}
