package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetTokenQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByPasswordResetTokenHandler {

	private final PasswordResetRepository repository;

	@QueryHandler
	public PasswordResetResponse handle(FindByPasswordResetTokenQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getToken().value();
		PasswordReset entity = repository.findByTokenAndTenantId(value, metaRequest.getTenantId()).orElse(null);

		if (entity == null) {
			throw new IllegalArgumentException("Token not found : " +
					query.getToken().value() + " , tenant: " + metaRequest.getTenantId());
		}

		return PasswordResetMapper.toResponse(entity);

	}


}
