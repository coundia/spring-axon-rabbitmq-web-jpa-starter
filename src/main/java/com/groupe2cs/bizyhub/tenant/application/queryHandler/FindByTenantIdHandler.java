package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByTenantIdHandler {

private final TenantRepository repository;
@QueryHandler

 public TenantResponse handle(FindByTenantIdQuery query) {

    MetaRequest metaRequest = query.getMetaRequest();
    Tenant entity = null;

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
		return TenantMapper.toResponse(entity);
	}

}
