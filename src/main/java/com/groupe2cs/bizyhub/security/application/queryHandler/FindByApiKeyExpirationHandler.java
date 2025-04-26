package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyExpirationQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
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
		java.time.Instant value = query.getExpiration().value();
		List<ApiKey> entities = repository.findByExpiration(value);
		return entities.stream()
				.map(ApiKeyMapper::toResponse)
				.toList();
	}


}
