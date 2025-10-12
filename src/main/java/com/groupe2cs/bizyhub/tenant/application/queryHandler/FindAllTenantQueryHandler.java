package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
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
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Tenant> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Tenants");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<TenantResponse> responses = pages.stream()
				.map(TenantMapper::toResponse)
				.toList();

		return TenantPagedResponse.from(
				pages,
				responses
		);
	}
}
