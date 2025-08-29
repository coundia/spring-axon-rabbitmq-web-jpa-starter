package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.mapper.VerificationCodeMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByVerificationCodePhoneQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByVerificationCodePhoneHandler {

	private final VerificationCodeRepository repository;

	@QueryHandler
	public List<VerificationCodeResponse> handle(FindByVerificationCodePhoneQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<VerificationCode> entities = null;
		String value = query.getPhone().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByPhoneAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByPhoneAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(VerificationCodeMapper::toResponse)
				.toList();
	}


}
