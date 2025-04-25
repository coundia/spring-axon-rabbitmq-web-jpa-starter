package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionTenant;

public class FindByTransactionTenantQuery {

	private final TransactionTenant tenant;

	public FindByTransactionTenantQuery(TransactionTenant tenant) {
		this.tenant = tenant;
	}

	public TransactionTenant getTenant() {
		return tenant;
	}
}
