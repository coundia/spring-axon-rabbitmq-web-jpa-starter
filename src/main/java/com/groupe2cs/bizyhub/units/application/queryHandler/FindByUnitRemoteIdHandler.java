package com.groupe2cs.bizyhub.units.application.queryHandler;

import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.units.infrastructure.entity.*;
import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.infrastructure.repository.*;
import com.groupe2cs.bizyhub.units.application.query.*;
import com.groupe2cs.bizyhub.units.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByUnitRemoteIdHandler {

private final UnitRepository repository;

@QueryHandler
public List<UnitResponse> handle(FindByUnitRemoteIdQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Unit> entities = null;
	 String value = query.getRemoteId().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByRemoteIdAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByRemoteIdAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(UnitMapper::toResponse)
	.toList();
	}


}
