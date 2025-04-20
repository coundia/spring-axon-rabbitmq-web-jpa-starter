package com.groupe2cs.bizyhub.transactions.domain.exception;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;

public class TransactionNotFoundException extends RuntimeException {

public TransactionNotFoundException(String object, String value) {
super("Transaction with "+object+": '" + value + "' not found");
}
}
