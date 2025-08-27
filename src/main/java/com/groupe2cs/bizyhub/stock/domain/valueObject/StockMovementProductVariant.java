package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCompanyNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementProductVariantNotValid;

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
public class StockMovementProductVariant implements Serializable {

private String productVariant;

public StockMovementProductVariant(String productVariant) {
this.productVariant = productVariant;
}

public static StockMovementProductVariant create(String productVariant) {

	return new StockMovementProductVariant(productVariant);
}

public String value() {
return this.productVariant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementProductVariant that)) return false;
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
