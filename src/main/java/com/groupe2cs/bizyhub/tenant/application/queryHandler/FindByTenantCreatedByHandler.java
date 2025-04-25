package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByTenantCreatedByHandler {

private final TenantRepository repository;
@QueryHandler
public List<TenantResponse> handle(FindByTenantCreatedByQuery query) {
String value = query.getCreatedBy().value();
	List<Tenant> entities = repository.findByCreatedBy(value);
	return entities.stream()
	.map(TenantMapper::toResponse)
	.toList();
	}


}
