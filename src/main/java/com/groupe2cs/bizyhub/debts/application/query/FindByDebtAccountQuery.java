package com.groupe2cs.bizyhub.debts.application.query;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByDebtAccountQuery {

	private final DebtAccount  account;
	private final MetaRequest metaRequest;

}
