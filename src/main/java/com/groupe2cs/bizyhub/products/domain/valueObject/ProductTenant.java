package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductRemoteIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductLocalIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDescriptionNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductBarcodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductUnitNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductSyncAtNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCategoryNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductAccountNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDefaultPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductStatusesNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPurchasePriceNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCreatedByNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductTenantNotValid;

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
public class ProductTenant implements Serializable {

private String tenant;

public ProductTenant(String tenant) {
this.tenant = tenant;
}

public static ProductTenant create(String tenant) {

	return new ProductTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
