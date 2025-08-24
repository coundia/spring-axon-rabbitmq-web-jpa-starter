package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;

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
public class StockLevelStockAllocated implements Serializable {

private Integer stockAllocated;

public StockLevelStockAllocated(Integer stockAllocated) {
this.stockAllocated = stockAllocated;
}

public static StockLevelStockAllocated create(Integer stockAllocated) {

	return new StockLevelStockAllocated(stockAllocated);
}

public Integer value() {
return this.stockAllocated;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelStockAllocated that)) return false;
return this.stockAllocated.equals(that.stockAllocated);
}

@Override
public int hashCode() {
return java.util.Objects.hash(stockAllocated);
}

@Override
public String toString() {
return String.valueOf(stockAllocated);
}
}
