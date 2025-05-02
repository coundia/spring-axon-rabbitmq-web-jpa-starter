package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTransactionIsExcluToRapportQuery {

	private final TransactionIsExcluToRapport  isExcluToRapport;
	private final MetaRequest metaRequest;

}
