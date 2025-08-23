package com.groupe2cs.bizyhub.sync.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllSyncStateQueryHandler {

private final SyncStateRepository repository;

public FindAllSyncStateQueryHandler(SyncStateRepository repository) {
	this.repository = repository;
}

@QueryHandler
public SyncStatePagedResponse handle(FindAllSyncStateQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<SyncState> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all SyncStates");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<SyncStateResponse> responses = pages.stream()
	.map(SyncStateMapper::toResponse)
	.toList();

	return SyncStatePagedResponse.from(
	pages,
	responses
	);
	}
}
