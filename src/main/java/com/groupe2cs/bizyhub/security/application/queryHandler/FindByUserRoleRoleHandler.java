package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleRoleQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByUserRoleRoleHandler {

	private final UserRoleRepository repository;

	@QueryHandler
	public List<UserRoleResponse> handle(FindByUserRoleRoleQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<UserRole> entities = null;
		String value = query.getRole().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByRoleIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByRoleIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(UserRoleMapper::toResponse)
				.toList();
	}


}
