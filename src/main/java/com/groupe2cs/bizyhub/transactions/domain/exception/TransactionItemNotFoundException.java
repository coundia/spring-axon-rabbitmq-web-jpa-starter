package com.groupe2cs.bizyhub.transactions.domain.exception;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemId;

public class TransactionItemNotFoundException extends RuntimeException {

public TransactionItemNotFoundException(String object, String value) {
super("TransactionItem with "+object+": '" + value + "' not found");
}
}
