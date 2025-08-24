package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelCompanyNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelCreatedByNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelTenantNotValid;

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
public class StockLevelTenant implements Serializable {

private String tenant;

public StockLevelTenant(String tenant) {
this.tenant = tenant;
}

public static StockLevelTenant create(String tenant) {

	return new StockLevelTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelTenant that)) return false;
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
