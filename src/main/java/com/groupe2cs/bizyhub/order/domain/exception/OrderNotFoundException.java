package com.groupe2cs.bizyhub.order.domain.exception;

import com.groupe2cs.bizyhub.order.domain.valueObject.OrderId;

public class OrderNotFoundException extends RuntimeException {

public OrderNotFoundException(String object, String value) {
super("Order with "+object+": '" + value + "' not found");
}
}
