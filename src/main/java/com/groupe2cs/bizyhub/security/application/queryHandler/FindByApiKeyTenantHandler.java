package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByApiKeyTenantHandler {

	private final ApiKeyRepository repository;

	@QueryHandler
	public List<ApiKeyResponse> handle(FindByApiKeyTenantQuery query) {
		String value = query.getTenant().value();
		List<ApiKey> entities = repository.findByTenant(value);
		return entities.stream()
				.map(ApiKeyMapper::toResponse)
				.toList();
	}


}
