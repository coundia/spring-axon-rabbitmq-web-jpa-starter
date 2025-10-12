package com.groupe2cs.bizyhub.debts.application.query;

import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtStatuses;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByDebtStatusesQuery {

	private final DebtStatuses statuses;
	private final MetaRequest metaRequest;

}
