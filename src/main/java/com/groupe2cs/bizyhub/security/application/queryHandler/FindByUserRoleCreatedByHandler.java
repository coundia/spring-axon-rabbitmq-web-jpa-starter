package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleCreatedByQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByUserRoleCreatedByHandler {

	private final UserRoleRepository repository;

	@QueryHandler
	public List<UserRoleResponse> handle(FindByUserRoleCreatedByQuery query) {
		String value = query.getCreatedBy().value();
		List<UserRole> entities = repository.findByCreatedBy(value);
		return entities.stream()
				.map(UserRoleMapper::toResponse)
				.toList();
	}


}
