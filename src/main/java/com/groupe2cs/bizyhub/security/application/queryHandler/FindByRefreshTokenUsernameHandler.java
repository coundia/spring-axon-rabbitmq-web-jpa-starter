package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenUsernameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRefreshTokenUsernameHandler {

	private final RefreshTokenRepository repository;

	@QueryHandler

	public RefreshTokenResponse handle(FindByRefreshTokenUsernameQuery query) {
		String value = query.getUsername().value();
		RefreshToken entity = repository.findByUsername(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return RefreshTokenMapper.toResponse(entity);
	}

}
