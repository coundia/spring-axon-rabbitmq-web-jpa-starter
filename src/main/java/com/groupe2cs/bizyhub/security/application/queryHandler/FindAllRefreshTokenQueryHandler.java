package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllRefreshTokenQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllRefreshTokenQueryHandler {

	private final RefreshTokenRepository repository;

	public FindAllRefreshTokenQueryHandler(RefreshTokenRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public RefreshTokenPagedResponse handle(FindAllRefreshTokenQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);

		Page<RefreshToken> pages = repository.findAll(pageable);

		List<RefreshTokenResponse> responses = pages.stream()
				.map(RefreshTokenMapper::toResponse)
				.toList();

		return RefreshTokenPagedResponse.from(
				pages,
				responses
		);
	}
}
