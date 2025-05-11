package com.groupe2cs.bizyhub.transactions.application.query;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTransactionUserCreatedByQuery {

	private final TransactionUserCreatedBy  createdBy;
	private final MetaRequest metaRequest;

}
