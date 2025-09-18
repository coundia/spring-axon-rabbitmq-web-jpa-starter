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
import com.groupe2cs.bizyhub.products.domain.exception.ProductLevelNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductQuantityNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductBarcodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCompanyNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUnitNotValid;

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
public class ProductUnit implements Serializable {

private String unit;

public ProductUnit(String unit) {
this.unit = unit;
}

public static ProductUnit create(String unit) {

	return new ProductUnit(unit);
}

public String value() {
return this.unit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductUnit that)) return false;
return this.unit.equals(that.unit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(unit);
}

@Override
public String toString() {
return String.valueOf(unit);
}
}
