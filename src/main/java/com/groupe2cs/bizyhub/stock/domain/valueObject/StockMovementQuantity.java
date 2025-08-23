package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;

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
public class StockMovementQuantity implements Serializable {

private Integer quantity;

public StockMovementQuantity(Integer quantity) {
this.quantity = quantity;
}

public static StockMovementQuantity create(Integer quantity) {

if (quantity < 0) {
throw new StockMovementQuantityNotValid("Quantity is invalid");
}
return new StockMovementQuantity(quantity);
}

public Integer value() {
return this.quantity;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementQuantity that)) return false;
return this.quantity.equals(that.quantity);
}

@Override
public int hashCode() {
return java.util.Objects.hash(quantity);
}

@Override
public String toString() {
return String.valueOf(quantity);
}
}
