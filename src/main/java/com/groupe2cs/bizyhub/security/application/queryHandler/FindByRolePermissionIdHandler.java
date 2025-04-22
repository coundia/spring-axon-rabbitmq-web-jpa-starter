package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRolePermissionIdQuery;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRolePermissionIdHandler {

	private final RolePermissionRepository repository;

	@QueryHandler

	public RolePermissionResponse handle(FindByRolePermissionIdQuery query) {
		String value = query.getId().value();
		RolePermission entity = repository.findById(value)
				.orElseThrow(() -> new RolePermissionNotFoundException("Id", value));
		return RolePermissionMapper.toResponse(entity);
	}

}
