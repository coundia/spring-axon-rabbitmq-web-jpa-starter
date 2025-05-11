package com.groupe2cs.bizyhub.balances.application.query;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByBalancePreviousBalanceQuery {

	private final BalancePreviousBalance  previousBalance;
	private final MetaRequest metaRequest;

}
