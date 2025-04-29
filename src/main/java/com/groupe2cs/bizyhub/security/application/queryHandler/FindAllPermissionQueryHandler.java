package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllPermissionQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
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
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Permission> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Permissions");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("Non-admin user, fetching Permissions by userId");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
		}

		List<PermissionResponse> responses = pages.stream()
				.map(PermissionMapper::toResponse)
				.toList();

		return PermissionPagedResponse.from(
				pages,
				responses
		);
	}
}
