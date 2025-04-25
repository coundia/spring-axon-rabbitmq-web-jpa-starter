package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class FindAllTenantQueryHandler {

private final TenantRepository repository;

public FindAllTenantQueryHandler(TenantRepository repository) {
	this.repository = repository;
}

@QueryHandler
public TenantPagedResponse handle(FindAllTenantQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Tenant> pages = repository.findAll(pageable);

List<TenantResponse> responses = pages.stream()
	.map(TenantMapper::toResponse)
	.toList();

	return TenantPagedResponse.from(
	pages,
	responses
	);
	}
}
