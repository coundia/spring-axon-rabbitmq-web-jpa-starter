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
public class ProductHasSold implements Serializable {

private Boolean hasSold;

public ProductHasSold(Boolean hasSold) {
this.hasSold = hasSold;
}

public static ProductHasSold create(Boolean hasSold) {

	return new ProductHasSold(hasSold);
}

public Boolean value() {
return this.hasSold;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductHasSold that)) return false;
return this.hasSold.equals(that.hasSold);
}

@Override
public int hashCode() {
return java.util.Objects.hash(hasSold);
}

@Override
public String toString() {
return String.valueOf(hasSold);
}
}
