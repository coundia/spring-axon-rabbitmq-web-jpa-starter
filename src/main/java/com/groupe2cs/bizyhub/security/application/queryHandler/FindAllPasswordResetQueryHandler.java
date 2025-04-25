package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllPasswordResetQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

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

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);

		Page<PasswordReset> pages = repository.findAll(pageable);

		List<PasswordResetResponse> responses = pages.stream()
				.map(PasswordResetMapper::toResponse)
				.toList();

		return PasswordResetPagedResponse.from(
				pages,
				responses
		);
	}
}
