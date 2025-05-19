package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByRolePermissionIdHandler {

private final RolePermissionRepository repository;

@QueryHandler

 public RolePermissionResponse handle(FindByRolePermissionIdQuery query) {

    MetaRequest metaRequest = query.getMetaRequest();
    RolePermission entity = null;

	String value = query.getId().value();

	if(metaRequest.isAdmin()) {
	    entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
	    .stream()
        .findFirst()
	    .orElse(null);
	 }else{
	    entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
	    .stream()
        .findFirst()
	    .orElse(null);
	 }

    if (entity == null) {
        return null;
    }
		return RolePermissionMapper.toResponse(entity);
	}

}
