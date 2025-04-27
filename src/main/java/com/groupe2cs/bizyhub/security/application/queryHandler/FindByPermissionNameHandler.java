package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPermissionNameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByPermissionNameHandler {

	private final PermissionRepository repository;

	@QueryHandler
	public List<PermissionResponse> handle(FindByPermissionNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getName().value();
		List<Permission> entities = repository.findByNameAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(PermissionMapper::toResponse)
				.toList();
	}


}
