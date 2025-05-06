package com.groupe2cs.bizyhub.sales.domain.exception;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleUserId;

public class SaleUserNotFoundException extends RuntimeException {

public SaleUserNotFoundException(String object, String value) {
super("SaleUser with "+object+": '" + value + "' not found");
}
}
