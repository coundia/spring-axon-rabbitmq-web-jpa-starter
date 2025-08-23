package com.groupe2cs.bizyhub.transactions.domain.exception;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionEntryId;

public class TransactionEntryNotFoundException extends RuntimeException {

public TransactionEntryNotFoundException(String object, String value) {
super("TransactionEntry with "+object+": '" + value + "' not found");
}
}
