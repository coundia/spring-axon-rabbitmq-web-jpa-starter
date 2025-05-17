package com.groupe2cs.bizyhub.accounts.application.query;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByAccountIdQuery {

	private final AccountId id;
	private final MetaRequest metaRequest;

}
