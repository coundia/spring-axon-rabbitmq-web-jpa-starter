package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserIsActive;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTransactionUserIsActiveQuery {

	private final TransactionUserIsActive isActive;
	private final MetaRequest metaRequest;

}
