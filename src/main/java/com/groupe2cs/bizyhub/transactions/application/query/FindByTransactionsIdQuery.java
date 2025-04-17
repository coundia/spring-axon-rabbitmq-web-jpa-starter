package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

public class FindByTransactionsIdQuery {

private final TransactionsId  id;

public FindByTransactionsIdQuery( TransactionsId id) {
	this.id = id;
}

public TransactionsId  getId() {
return id;
}
}
