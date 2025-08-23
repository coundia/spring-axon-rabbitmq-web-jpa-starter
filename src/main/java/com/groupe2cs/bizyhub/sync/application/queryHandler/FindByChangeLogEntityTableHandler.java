package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.sync.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByChangeLogEntityTableHandler {

private final ChangeLogRepository repository;

@QueryHandler
public List<ChangeLogResponse> handle(FindByChangeLogEntityTableQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<ChangeLog> entities = null;
	 String value = query.getEntityTable().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByEntityTableAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByEntityTableAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(ChangeLogMapper::toResponse)
	.toList();
	}


}
