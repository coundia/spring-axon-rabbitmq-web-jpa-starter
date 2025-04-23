package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenIdQuery;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRefreshTokenIdHandler {

	private final RefreshTokenRepository repository;

	@QueryHandler

	public RefreshTokenResponse handle(FindByRefreshTokenIdQuery query) {
		String value = query.getId().value();
		RefreshToken entity = repository.findById(value)
				.orElseThrow(() -> new RefreshTokenNotFoundException("Id", value));
		return RefreshTokenMapper.toResponse(entity);
	}

}
