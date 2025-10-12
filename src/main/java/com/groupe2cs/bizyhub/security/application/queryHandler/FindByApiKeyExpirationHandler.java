package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;


@Component
@RequiredArgsConstructor
public class FindByApiKeyExpirationHandler {

	private final ApiKeyRepository repository;

	@QueryHandler
	public List<ApiKeyResponse> handle(FindByApiKeyExpirationQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<ApiKey> entities = null;
		java.time.Instant value = query.getExpiration().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByExpirationAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByExpirationAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ApiKeyMapper::toResponse)
				.toList();
	}


}
