package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindAllRoleQuery {

	private final int page;
	private final int limit;
	private final MetaRequest metaRequest;

}
