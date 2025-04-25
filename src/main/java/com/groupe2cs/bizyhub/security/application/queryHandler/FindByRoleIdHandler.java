package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByRoleIdHandler {

private final RoleRepository repository;
@QueryHandler

 public RoleResponse handle(FindByRoleIdQuery query) {
	String value = query.getId().value();
	Role entity = repository.findById(value)
		.orElse(null);

		if (entity == null) {
			return null;
		}

		return RoleMapper.toResponse(entity);
	}

}
