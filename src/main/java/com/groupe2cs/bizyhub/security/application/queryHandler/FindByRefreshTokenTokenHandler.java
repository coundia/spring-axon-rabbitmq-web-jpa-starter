package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenTokenQuery;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRefreshTokenTokenHandler {

	private final RefreshTokenRepository repository;

	@QueryHandler

	public RefreshTokenResponse handle(FindByRefreshTokenTokenQuery query) {
		String value = query.getToken().value();
		RefreshToken entity = repository.findByToken(value)
				.orElseThrow(() -> new RefreshTokenNotFoundException("Token", value));
		return RefreshTokenMapper.toResponse(entity);
	}

}
