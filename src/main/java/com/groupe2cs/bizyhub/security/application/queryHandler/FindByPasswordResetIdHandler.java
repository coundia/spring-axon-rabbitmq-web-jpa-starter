package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetIdQuery;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByPasswordResetIdHandler {

	private final PasswordResetRepository repository;

	@QueryHandler

	public PasswordResetResponse handle(FindByPasswordResetIdQuery query) {
		String value = query.getId().value();
		PasswordReset entity = repository.findById(value)
				.orElseThrow(() -> new PasswordResetNotFoundException("Id", value));
		return PasswordResetMapper.toResponse(entity);
	}

}
