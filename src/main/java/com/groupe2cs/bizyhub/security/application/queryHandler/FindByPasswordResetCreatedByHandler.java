package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetCreatedByQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByPasswordResetCreatedByHandler {

	private final PasswordResetRepository repository;

	@QueryHandler
	public List<PasswordResetResponse> handle(FindByPasswordResetCreatedByQuery query) {
		String value = query.getCreatedBy().value();
		List<PasswordReset> entities = repository.findByCreatedBy(value);
		return entities.stream()
				.map(PasswordResetMapper::toResponse)
				.toList();
	}


}
