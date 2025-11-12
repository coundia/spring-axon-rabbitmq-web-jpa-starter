package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.VerificationCodePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.mapper.VerificationCodeMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllVerificationCodeQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllVerificationCodeQueryHandler {

	private final VerificationCodeRepository repository;

	public FindAllVerificationCodeQueryHandler(VerificationCodeRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public VerificationCodePagedResponse handle(FindAllVerificationCodeQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<VerificationCode> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all VerificationCodes");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<VerificationCodeResponse> responses = pages.stream()
				.map(VerificationCodeMapper::toResponse)
				.toList();

		return VerificationCodePagedResponse.from(
				pages,
				responses
		);
	}
}
