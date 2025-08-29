package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.mapper.VerificationCodeMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByVerificationCodeExpirationQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByVerificationCodeExpirationHandler {

	private final VerificationCodeRepository repository;

	@QueryHandler
	public List<VerificationCodeResponse> handle(FindByVerificationCodeExpirationQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<VerificationCode> entities = null;
		java.time.Instant value = query.getExpiration().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByExpirationAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByExpirationAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(VerificationCodeMapper::toResponse)
				.toList();
	}


}
