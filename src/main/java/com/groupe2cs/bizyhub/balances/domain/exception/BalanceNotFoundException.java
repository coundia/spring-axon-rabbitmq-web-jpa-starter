package com.groupe2cs.bizyhub.balances.domain.exception;

import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceId;

public class BalanceNotFoundException extends RuntimeException {

public BalanceNotFoundException(String object, String value) {
super("Balance with "+object+": '" + value + "' not found");
}
}
