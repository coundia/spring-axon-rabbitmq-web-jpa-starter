package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;

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
public class StockLevelStockOnHand implements Serializable {

private Integer stockOnHand;

public StockLevelStockOnHand(Integer stockOnHand) {
this.stockOnHand = stockOnHand;
}

public static StockLevelStockOnHand create(Integer stockOnHand) {

	return new StockLevelStockOnHand(stockOnHand);
}

public Integer value() {
return this.stockOnHand;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelStockOnHand that)) return false;
return this.stockOnHand.equals(that.stockOnHand);
}

@Override
public int hashCode() {
return java.util.Objects.hash(stockOnHand);
}

@Override
public String toString() {
return String.valueOf(stockOnHand);
}
}
