package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyExpirationQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


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
