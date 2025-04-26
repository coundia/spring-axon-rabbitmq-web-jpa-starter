package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindByTenantDescriptionQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByTenantDescriptionHandler {

	private final TenantRepository repository;

	@QueryHandler
	public List<TenantResponse> handle(FindByTenantDescriptionQuery query) {
		String value = query.getDescription().value();
		List<Tenant> entities = repository.findByDescription(value);
		return entities.stream()
				.map(TenantMapper::toResponse)
				.toList();
	}


}
