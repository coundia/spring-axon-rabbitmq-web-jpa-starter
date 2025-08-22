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
public class FindByTenantDomainHandler {

private final TenantRepository repository;

@QueryHandler
public List<TenantResponse> handle(FindByTenantDomainQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Tenant> entities = null;
	 String value = query.getDomain().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByDomainAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByDomainAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TenantMapper::toResponse)
	.toList();
	}


}
