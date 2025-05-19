package com.groupe2cs.bizyhub.accounts.application.query;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByAccountDetailsQuery {

	private final AccountDetails  details;
	private final MetaRequest metaRequest;

}
