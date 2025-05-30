package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllApiKeyQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllApiKeyQueryHandler {

	private final ApiKeyRepository repository;

	public FindAllApiKeyQueryHandler(ApiKeyRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public ApiKeyPagedResponse handle(FindAllApiKeyQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<ApiKey> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all ApiKeys");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
		}

		List<ApiKeyResponse> responses = pages.stream()
				.map(ApiKeyMapper::toResponse)
				.toList();

		return ApiKeyPagedResponse.from(
				pages,
				responses
		);
	}
}
