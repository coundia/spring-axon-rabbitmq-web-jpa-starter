package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenTokenQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByRefreshTokenTokenHandler {

	private final RefreshTokenRepository repository;

	@QueryHandler
	public List<RefreshTokenResponse> handle(FindByRefreshTokenTokenQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<RefreshToken> entities = null;
		String value = query.getToken().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTokenAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTokenAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(RefreshTokenMapper::toResponse)
				.toList();
	}


}
