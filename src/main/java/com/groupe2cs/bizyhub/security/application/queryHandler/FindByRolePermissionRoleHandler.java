package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRolePermissionRoleQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByRolePermissionRoleHandler {

	private final RolePermissionRepository repository;

	@QueryHandler
	public List<RolePermissionResponse> handle(FindByRolePermissionRoleQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<RolePermission> entities = null;
		String value = query.getRole().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByRoleIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByRoleIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(RolePermissionMapper::toResponse)
				.toList();
	}


}
