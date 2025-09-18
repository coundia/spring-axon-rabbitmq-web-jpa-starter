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
import com.groupe2cs.bizyhub.products.domain.exception.ProductSyncAtNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCategoryNotValid;

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
public class ProductCategory implements Serializable {

private String category;

public ProductCategory(String category) {
this.category = category;
}

public static ProductCategory create(String category) {

	return new ProductCategory(category);
}

public String value() {
return this.category;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductCategory that)) return false;
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
