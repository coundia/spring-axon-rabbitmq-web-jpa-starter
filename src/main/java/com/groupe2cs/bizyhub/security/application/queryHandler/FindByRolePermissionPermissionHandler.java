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
public class FindByRolePermissionPermissionHandler {

private final RolePermissionRepository repository;
@QueryHandler
public List<RolePermissionResponse> handle(FindByRolePermissionPermissionQuery query) {
String value = query.getPermission().value();
	List<RolePermission> entities = repository.findByPermission(value);
	return entities.stream()
	.map(RolePermissionMapper::toResponse)
	.toList();
	}


}
