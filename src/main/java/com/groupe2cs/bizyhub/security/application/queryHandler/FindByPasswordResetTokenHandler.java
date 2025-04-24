package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetTokenQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByPasswordResetTokenHandler {

	private final PasswordResetRepository repository;

	@QueryHandler

	public PasswordResetResponse handle(FindByPasswordResetTokenQuery query) {
		String value = query.getToken().value();
		PasswordReset entity = repository.findByToken(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return PasswordResetMapper.toResponse(entity);
	}

}
