package com.groupe2cs.bizyhub.transactions.domain.exception;

public class TransactionIdNotValid extends RuntimeException {
    public TransactionIdNotValid(String message) {
        super(message);
    }
}
