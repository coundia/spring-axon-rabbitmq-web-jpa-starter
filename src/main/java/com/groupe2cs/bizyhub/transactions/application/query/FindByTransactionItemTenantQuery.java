package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemTenant;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTransactionItemTenantQuery {

	private final TransactionItemTenant tenant;
	private final MetaRequest metaRequest;

}
