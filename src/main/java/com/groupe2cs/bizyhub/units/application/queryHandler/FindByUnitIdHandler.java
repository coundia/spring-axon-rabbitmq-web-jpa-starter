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
public class FindByUnitIdHandler {

private final UnitRepository repository;

@QueryHandler

 public UnitResponse handle(FindByUnitIdQuery query) {

    MetaRequest metaRequest = query.getMetaRequest();
    Unit entity = null;

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
		return UnitMapper.toResponse(entity);
	}

}
