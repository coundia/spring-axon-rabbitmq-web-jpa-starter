package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyActiveQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByApiKeyActiveHandler {

	private final ApiKeyRepository repository;

	@QueryHandler
	public List<ApiKeyResponse> handle(FindByApiKeyActiveQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<ApiKey> entities = null;
		Boolean value = query.getActive().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByActiveAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByActiveAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ApiKeyMapper::toResponse)
				.toList();
	}


}
