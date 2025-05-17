package com.groupe2cs.bizyhub.accounts.application.query;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByAccountUserIdQuery {

	private final AccountUserId id;
	private final MetaRequest metaRequest;

}
