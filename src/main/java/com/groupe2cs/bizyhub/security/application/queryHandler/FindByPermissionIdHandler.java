package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByPermissionIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByPermissionIdHandler {

	private final PermissionRepository repository;

	@QueryHandler

	public PermissionResponse handle(FindByPermissionIdQuery query) {
		String value = query.getId().value();
		Permission entity = repository.findById(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return PermissionMapper.toResponse(entity);
	}

}
