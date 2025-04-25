package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetExpirationQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByPasswordResetExpirationHandler {

	private final PasswordResetRepository repository;

	@QueryHandler
	public List<PasswordResetResponse> handle(FindByPasswordResetExpirationQuery query) {
		java.time.Instant value = query.getExpiration().value();
		List<PasswordReset> entities = repository.findByExpiration(value);
		return entities.stream()
				.map(PasswordResetMapper::toResponse)
				.toList();
	}


}
