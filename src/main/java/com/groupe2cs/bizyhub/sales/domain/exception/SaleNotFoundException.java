package com.groupe2cs.bizyhub.sales.domain.exception;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;

public class SaleNotFoundException extends RuntimeException {

public SaleNotFoundException(SaleId id) {
super("Sale with ID " + id + " not found");
}
}
