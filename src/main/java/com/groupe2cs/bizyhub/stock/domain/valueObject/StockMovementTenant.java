package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementAccountNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCompanyNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementOrderLineIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementDiscriminatorNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCreatedByNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTenantNotValid;

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
public class StockMovementTenant implements Serializable {

private String tenant;

public StockMovementTenant(String tenant) {
this.tenant = tenant;
}

public static StockMovementTenant create(String tenant) {

	return new StockMovementTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementTenant that)) return false;
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
