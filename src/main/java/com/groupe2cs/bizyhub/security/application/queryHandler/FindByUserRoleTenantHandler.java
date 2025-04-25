package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByUserRoleTenantHandler {

	private final UserRoleRepository repository;

	@QueryHandler
	public List<UserRoleResponse> handle(FindByUserRoleTenantQuery query) {
		String value = query.getTenant().value();
		List<UserRole> entities = repository.findByTenant(value);
		return entities.stream()
				.map(UserRoleMapper::toResponse)
				.toList();
	}


}
