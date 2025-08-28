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
public class FindAllChangeLogQueryHandler {

private final ChangeLogRepository repository;

public FindAllChangeLogQueryHandler(ChangeLogRepository repository) {
	this.repository = repository;
}

@QueryHandler
public ChangeLogPagedResponse handle(FindAllChangeLogQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<ChangeLog> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all ChangeLogs");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{

log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);


}

List<ChangeLogResponse> responses = pages.stream()
	.map(ChangeLogMapper::toResponse)
	.toList();

	return ChangeLogPagedResponse.from(
	pages,
	responses
	);
	}
}
