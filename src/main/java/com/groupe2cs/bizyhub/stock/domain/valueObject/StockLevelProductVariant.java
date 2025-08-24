package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelProductVariantNotValid;

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
public class StockLevelProductVariant implements Serializable {

private String productVariant;

public StockLevelProductVariant(String productVariant) {
this.productVariant = productVariant;
}

public static StockLevelProductVariant create(String productVariant) {

if (productVariant == null || productVariant.isBlank()) {
throw new StockLevelProductVariantNotValid("ProductVariant is invalid");
}
return new StockLevelProductVariant(productVariant);
}

public String value() {
return this.productVariant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelProductVariant that)) return false;
return this.productVariant.equals(that.productVariant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(productVariant);
}

@Override
public String toString() {
return String.valueOf(productVariant);
}
}
