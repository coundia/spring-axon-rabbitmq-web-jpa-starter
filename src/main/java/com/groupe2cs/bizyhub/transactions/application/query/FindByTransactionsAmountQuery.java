package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

public class FindByTransactionsAmountQuery {

private final TransactionsAmount  amount;

public FindByTransactionsAmountQuery( TransactionsAmount amount) {
	this.amount = amount;
}

public TransactionsAmount  getAmount() {
return amount;
}
}
