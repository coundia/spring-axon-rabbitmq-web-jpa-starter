package com.groupe2cs.bizyhub.units.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.infrastructure.repository.*;
import com.groupe2cs.bizyhub.units.application.query.*;
import com.groupe2cs.bizyhub.units.infrastructure.entity.*;
import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllUnitQueryHandler {

private final UnitRepository repository;

public FindAllUnitQueryHandler(UnitRepository repository) {
	this.repository = repository;
}

@QueryHandler
public UnitPagedResponse handle(FindAllUnitQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Unit> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Units");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<UnitResponse> responses = pages.stream()
	.map(UnitMapper::toResponse)
	.toList();

	return UnitPagedResponse.from(
	pages,
	responses
	);
	}
}
