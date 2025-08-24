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
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementOrderLineIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementDiscriminatorNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCreatedByNotValid;

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
public class StockMovementCreatedBy implements Serializable {

private String createdBy;

public StockMovementCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static StockMovementCreatedBy create(String createdBy) {

	return new StockMovementCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
