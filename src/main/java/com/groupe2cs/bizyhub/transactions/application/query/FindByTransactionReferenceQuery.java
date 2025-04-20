package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

public class FindByTransactionReferenceQuery {

private final TransactionReference  reference;

public FindByTransactionReferenceQuery( TransactionReference reference) {
	this.reference = reference;
}

public TransactionReference  getReference() {
return reference;
}
}
