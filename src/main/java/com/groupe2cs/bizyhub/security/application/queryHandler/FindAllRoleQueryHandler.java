package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllRoleQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllRoleQueryHandler {

	private final RoleRepository repository;

	public FindAllRoleQueryHandler(RoleRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public RolePagedResponse handle(FindAllRoleQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Role> pages = null;

		if (metaRequest.isAdmin()) {
			pages = repository.findAll(pageable);
			//pages = repository.findAllByTenantId(pageable, metaRequest.getTenantId());
		} else {
			pages = repository.findByCreatedById(pageable, metaRequest.getUserId());
		}

		List<RoleResponse> responses = pages.stream()
				.map(RoleMapper::toResponse)
				.toList();

		return RolePagedResponse.from(
				pages,
				responses
		);
	}
}
