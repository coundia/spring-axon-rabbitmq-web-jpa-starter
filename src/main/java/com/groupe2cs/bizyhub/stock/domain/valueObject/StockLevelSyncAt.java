package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelSyncAtNotValid;

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
public class StockLevelSyncAt implements Serializable {

private java.time.Instant syncAt;

public StockLevelSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static StockLevelSyncAt create(java.time.Instant syncAt) {

	return new StockLevelSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
