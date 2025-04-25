package com.groupe2cs.bizyhub.security.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class FindAllPermissionQueryHandler {

private final PermissionRepository repository;

public FindAllPermissionQueryHandler(PermissionRepository repository) {
	this.repository = repository;
}

@QueryHandler
public PermissionPagedResponse handle(FindAllPermissionQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Permission> pages = repository.findAll(pageable);

List<PermissionResponse> responses = pages.stream()
	.map(PermissionMapper::toResponse)
	.toList();

	return PermissionPagedResponse.from(
	pages,
	responses
	);
	}
}
