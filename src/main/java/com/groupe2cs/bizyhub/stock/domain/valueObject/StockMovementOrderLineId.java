package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCompanyNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementOrderLineIdNotValid;

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
public class StockMovementOrderLineId implements Serializable {

private String orderLineId;

public StockMovementOrderLineId(String orderLineId) {
this.orderLineId = orderLineId;
}

public static StockMovementOrderLineId create(String orderLineId) {

	return new StockMovementOrderLineId(orderLineId);
}

public String value() {
return this.orderLineId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementOrderLineId that)) return false;
return this.orderLineId.equals(that.orderLineId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(orderLineId);
}

@Override
public String toString() {
return String.valueOf(orderLineId);
}
}
