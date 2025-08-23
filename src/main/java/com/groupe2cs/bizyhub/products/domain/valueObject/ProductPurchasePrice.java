package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductRemoteIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDescriptionNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductBarcodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUnitNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductSyncAtNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCategoryNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDefaultPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductStatusesNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPurchasePriceNotValid;

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
public class ProductPurchasePrice implements Serializable {

private Double purchasePrice;

public ProductPurchasePrice(Double purchasePrice) {
this.purchasePrice = purchasePrice;
}

public static ProductPurchasePrice create(Double purchasePrice) {

if (purchasePrice == null) {
throw new ProductPurchasePriceNotValid("PurchasePrice is invalid");
}
return new ProductPurchasePrice(purchasePrice);
}

public Double value() {
return this.purchasePrice;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductPurchasePrice that)) return false;
return this.purchasePrice.equals(that.purchasePrice);
}

@Override
public int hashCode() {
return java.util.Objects.hash(purchasePrice);
}

@Override
public String toString() {
return String.valueOf(purchasePrice);
}
}
