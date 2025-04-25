package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantPagedResponse;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindAllTenantQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

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
