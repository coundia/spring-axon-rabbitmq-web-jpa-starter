package com.groupe2cs.bizyhub.transactions.domain.exception;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionsId;

public class TransactionsNotFoundException extends RuntimeException {

public TransactionsNotFoundException(TransactionsId id) {
super("Transactions with ID " + id + " not found");
}
}
