package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

public class FindByTransactionsReferenceQuery {

private final TransactionsReference  reference;

public FindByTransactionsReferenceQuery( TransactionsReference reference) {
	this.reference = reference;
}

public TransactionsReference  getReference() {
return reference;
}
}
