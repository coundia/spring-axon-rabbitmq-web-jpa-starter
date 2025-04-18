package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionReferenceNotValid extends RuntimeException {
    public TransactionReferenceNotValid(String message) {
        super(message);
    }
}
