package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;

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
public class StockMovementTypeStockMovement implements Serializable {

private String typeStockMovement;

public StockMovementTypeStockMovement(String typeStockMovement) {
this.typeStockMovement = typeStockMovement;
}

public static StockMovementTypeStockMovement create(String typeStockMovement) {

if (typeStockMovement == null || typeStockMovement.isBlank()) {
throw new StockMovementTypeStockMovementNotValid("TypeStockMovement is invalid");
}
return new StockMovementTypeStockMovement(typeStockMovement);
}

public String value() {
return this.typeStockMovement;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementTypeStockMovement that)) return false;
return this.typeStockMovement.equals(that.typeStockMovement);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeStockMovement);
}

@Override
public String toString() {
return String.valueOf(typeStockMovement);
}
}
