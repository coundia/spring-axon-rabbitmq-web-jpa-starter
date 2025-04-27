package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleNameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByRoleNameHandler {

	private final RoleRepository repository;

	@QueryHandler
	public List<RoleResponse> handle(FindByRoleNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getName().value();
		List<Role> entities = repository.findByNameAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(RoleMapper::toResponse)
				.toList();
	}


}
