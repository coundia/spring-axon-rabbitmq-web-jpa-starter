package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllPermissionQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPermissionQueryHandler {

	private final PermissionRepository repository;

	public FindAllPermissionQueryHandler(PermissionRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public PermissionPagedResponse handle(FindAllPermissionQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);

		Page<Permission> pages = repository.findAll(pageable);

		List<PermissionResponse> responses = pages.stream()
				.map(PermissionMapper::toResponse)
				.toList();

		return PermissionPagedResponse.from(
				pages,
				responses
		);
	}
}
