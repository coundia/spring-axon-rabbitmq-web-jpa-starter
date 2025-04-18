package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;

public class FindByTransactionIdQuery {

    private final TransactionId id;

    public FindByTransactionIdQuery(TransactionId id) {
        this.id = id;
    }

    public TransactionId getId() {
        return id;
    }
}
