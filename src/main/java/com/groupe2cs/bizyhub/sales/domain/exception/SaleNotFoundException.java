package com.groupe2cs.bizyhub.sales.domain.exception;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;

public class SaleNotFoundException extends RuntimeException {

public SaleNotFoundException(String object, String value) {
super("Sale with "+object+": '" + value + "' not found");
}
}
