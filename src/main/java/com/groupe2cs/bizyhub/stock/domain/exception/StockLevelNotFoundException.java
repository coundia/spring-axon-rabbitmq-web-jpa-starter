package com.groupe2cs.bizyhub.stock.domain.exception;

import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelId;

public class StockLevelNotFoundException extends RuntimeException {

public StockLevelNotFoundException(String object, String value) {
super("StockLevel with "+object+": '" + value + "' not found");
}
}
