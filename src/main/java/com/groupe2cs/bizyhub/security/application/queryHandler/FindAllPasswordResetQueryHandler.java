package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllPasswordResetQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllPasswordResetQueryHandler {

	private final PasswordResetRepository repository;

	public FindAllPasswordResetQueryHandler(PasswordResetRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public PasswordResetPagedResponse handle(FindAllPasswordResetQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<PasswordReset> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all PasswordResets");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<PasswordResetResponse> responses = pages.stream()
				.map(PasswordResetMapper::toResponse)
				.toList();

		return PasswordResetPagedResponse.from(
				pages,
				responses
		);
	}
}
