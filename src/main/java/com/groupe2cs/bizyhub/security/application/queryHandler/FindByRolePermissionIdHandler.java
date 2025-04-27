package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByRolePermissionIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByRolePermissionIdHandler {

	private final RolePermissionRepository repository;

	@QueryHandler

	public RolePermissionResponse handle(FindByRolePermissionIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getId().value();
		RolePermission entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return RolePermissionMapper.toResponse(entity);
	}

}
