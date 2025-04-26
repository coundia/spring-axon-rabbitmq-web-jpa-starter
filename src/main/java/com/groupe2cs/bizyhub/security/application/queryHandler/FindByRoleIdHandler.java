package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRoleIdHandler {

	private final RoleRepository repository;

	@QueryHandler

	public RoleResponse handle(FindByRoleIdQuery query) {
		String value = query.getId().value();
		Role entity = repository.findById(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return RoleMapper.toResponse(entity);
	}

}
