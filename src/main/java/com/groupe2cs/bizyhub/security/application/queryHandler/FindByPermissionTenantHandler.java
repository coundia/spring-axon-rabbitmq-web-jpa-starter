package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPermissionTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByPermissionTenantHandler {

	private final PermissionRepository repository;

	@QueryHandler
	public List<PermissionResponse> handle(FindByPermissionTenantQuery query) {
		String value = query.getTenant().value();
		List<Permission> entities = repository.findByTenant(value);
		return entities.stream()
				.map(PermissionMapper::toResponse)
				.toList();
	}


}
