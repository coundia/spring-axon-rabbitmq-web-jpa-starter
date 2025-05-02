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

	String value = query.getId().value();
	Tenant entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
		.orElse(null);

		if (entity == null) {
			return null;
		}

		return TenantMapper.toResponse(entity);
	}

}
