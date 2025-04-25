package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByRoleTenantHandler {

	private final RoleRepository repository;

	@QueryHandler
	public List<RoleResponse> handle(FindByRoleTenantQuery query) {
		String value = query.getTenant().value();
		List<Role> entities = repository.findByTenant(value);
		return entities.stream()
				.map(RoleMapper::toResponse)
				.toList();
	}


}
