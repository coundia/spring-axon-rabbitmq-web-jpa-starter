package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPermissionNameQuery;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionNotFoundException;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByPermissionNameHandler {

	private final PermissionRepository repository;

	@QueryHandler

	public PermissionResponse handle(FindByPermissionNameQuery query) {
		String value = query.getName().value();
		Permission entity = repository.findByName(value)
				.orElseThrow(() -> new PermissionNotFoundException("Name", value));
		return PermissionMapper.toResponse(entity);
	}

}
