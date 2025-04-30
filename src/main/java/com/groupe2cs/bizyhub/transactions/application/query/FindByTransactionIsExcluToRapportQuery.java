package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionIsExcluToRapport;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTransactionIsExcluToRapportQuery {

	private final TransactionIsExcluToRapport isExcluToRapport;
	private final MetaRequest metaRequest;

}
