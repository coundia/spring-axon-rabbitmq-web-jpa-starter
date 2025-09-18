package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductRemoteIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductLocalIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDescriptionNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductStatusNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIsPublicNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductHasSoldNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductHasPriceNotValid;

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
public class ProductHasPrice implements Serializable {

private Boolean hasPrice;

public ProductHasPrice(Boolean hasPrice) {
this.hasPrice = hasPrice;
}

public static ProductHasPrice create(Boolean hasPrice) {

	return new ProductHasPrice(hasPrice);
}

public Boolean value() {
return this.hasPrice;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductHasPrice that)) return false;
return this.hasPrice.equals(that.hasPrice);
}

@Override
public int hashCode() {
return java.util.Objects.hash(hasPrice);
}

@Override
public String toString() {
return String.valueOf(hasPrice);
}
}
