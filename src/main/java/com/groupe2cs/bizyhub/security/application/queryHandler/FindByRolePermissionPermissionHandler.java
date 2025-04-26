package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRolePermissionPermissionQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByRolePermissionPermissionHandler {

	private final RolePermissionRepository repository;

	@QueryHandler
	public List<RolePermissionResponse> handle(FindByRolePermissionPermissionQuery query) {
		String value = query.getPermission().value();
		List<RolePermission> entities = repository.findByPermission(value);
		return entities.stream()
				.map(RolePermissionMapper::toResponse)
				.toList();
	}


}
