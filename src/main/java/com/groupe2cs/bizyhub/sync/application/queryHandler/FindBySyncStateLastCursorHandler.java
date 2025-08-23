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
public class FindBySyncStateLastCursorHandler {

private final SyncStateRepository repository;

@QueryHandler
public List<SyncStateResponse> handle(FindBySyncStateLastCursorQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<SyncState> entities = null;
	 String value = query.getLastCursor().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByLastCursorAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByLastCursorAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(SyncStateMapper::toResponse)
	.toList();
	}


}
