package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleCreatedByQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByRoleCreatedByHandler {

	private final RoleRepository repository;

	@QueryHandler
	public List<RoleResponse> handle(FindByRoleCreatedByQuery query) {
		String value = query.getCreatedBy().value();
		List<Role> entities = repository.findByCreatedBy(value);
		return entities.stream()
				.map(RoleMapper::toResponse)
				.toList();
	}


}
