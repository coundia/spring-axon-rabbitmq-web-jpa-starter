package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyUsernameQuery;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByApiKeyUsernameHandler {

	private final ApiKeyRepository repository;

	@QueryHandler

	public ApiKeyResponse handle(FindByApiKeyUsernameQuery query) {
		String value = query.getUsername().value();
		ApiKey entity = repository.findByUsername(value)
				.orElseThrow(() -> new ApiKeyNotFoundException("Username", value));
		return ApiKeyMapper.toResponse(entity);
	}

}
