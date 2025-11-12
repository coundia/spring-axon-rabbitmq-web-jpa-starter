package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPermissionTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByPermissionTenantHandler {

	private final PermissionRepository repository;

	@QueryHandler
	public List<PermissionResponse> handle(FindByPermissionTenantQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Permission> entities = null;
		String value = query.getTenant().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTenantIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTenantIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(PermissionMapper::toResponse)
				.toList();
	}


}
