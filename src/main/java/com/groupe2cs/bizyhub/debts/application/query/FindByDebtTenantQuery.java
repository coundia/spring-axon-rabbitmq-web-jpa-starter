package com.groupe2cs.bizyhub.debts.application.query;

import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByDebtTenantQuery {

	private final DebtTenant tenant;
	private final MetaRequest metaRequest;

}
