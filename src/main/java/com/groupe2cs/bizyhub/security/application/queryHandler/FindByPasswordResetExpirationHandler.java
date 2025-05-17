package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetExpirationQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
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

		MetaRequest metaRequest = query.getMetaRequest();
		List<PasswordReset> entities = null;
		java.time.Instant value = query.getExpiration().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByExpirationAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByExpirationAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(PasswordResetMapper::toResponse)
				.toList();
	}


}
