package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDetailsNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIsActiveNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUpdatedAtNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductReferenceNotValid;

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
public class ProductReference implements Serializable {

private String reference;

public ProductReference(String reference) {
this.reference = reference;
}

public static ProductReference create(String reference) {

	return new ProductReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductReference that)) return false;
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
