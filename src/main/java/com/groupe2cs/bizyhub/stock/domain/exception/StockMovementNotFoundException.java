package com.groupe2cs.bizyhub.stock.domain.exception;

import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;

public class StockMovementNotFoundException extends RuntimeException {

public StockMovementNotFoundException(String object, String value) {
super("StockMovement with "+object+": '" + value + "' not found");
}
}
