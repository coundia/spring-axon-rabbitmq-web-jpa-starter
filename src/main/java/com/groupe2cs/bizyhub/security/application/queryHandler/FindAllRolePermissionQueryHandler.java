package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllRolePermissionQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllRolePermissionQueryHandler {

	private final RolePermissionRepository repository;

	public FindAllRolePermissionQueryHandler(RolePermissionRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public RolePermissionPagedResponse handle(FindAllRolePermissionQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<RolePermission> pages = null;

		if (metaRequest.isAdmin()) {
			pages = repository.findAll(pageable);
			//pages = repository.findAllByTenantId(pageable, metaRequest.getTenantId());
		} else {
			pages = repository.findByCreatedById(pageable, metaRequest.getUserId());
		}

		List<RolePermissionResponse> responses = pages.stream()
				.map(RolePermissionMapper::toResponse)
				.toList();

		return RolePermissionPagedResponse.from(
				pages,
				responses
		);
	}
}
