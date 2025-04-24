package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyKeyQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByApiKeyKeyHandler {

	private final ApiKeyRepository repository;

	@QueryHandler

	public ApiKeyResponse handle(FindByApiKeyKeyQuery query) {
		String value = query.getKey().value();
		ApiKey entity = repository.findByKey(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return ApiKeyMapper.toResponse(entity);
	}

}
