package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindByRoleIdHandler {

	private final RoleRepository repository;

	@QueryHandler

	public RoleResponse handle(FindByRoleIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		Role entity = null;

		String value = query.getId().value();

		if (metaRequest.isAdmin()) {
			entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
					.stream()
					.findFirst()
					.orElse(null);
		} else {
			entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
					.stream()
					.findFirst()
					.orElse(null);
		}

		if (entity == null) {
			return null;
		}
		return RoleMapper.toResponse(entity);
	}

}
