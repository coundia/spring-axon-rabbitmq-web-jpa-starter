package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenCreatedByQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByRefreshTokenCreatedByHandler {

	private final RefreshTokenRepository repository;

	@QueryHandler
	public List<RefreshTokenResponse> handle(FindByRefreshTokenCreatedByQuery query) {
		String value = query.getCreatedBy().value();
		List<RefreshToken> entities = repository.findByCreatedBy(value);
		return entities.stream()
				.map(RefreshTokenMapper::toResponse)
				.toList();
	}


}
