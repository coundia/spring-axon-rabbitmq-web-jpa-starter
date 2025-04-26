package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByUserRoleIdHandler {

	private final UserRoleRepository repository;

	@QueryHandler

	public UserRoleResponse handle(FindByUserRoleIdQuery query) {
		String value = query.getId().value();
		UserRole entity = repository.findById(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return UserRoleMapper.toResponse(entity);
	}

}
