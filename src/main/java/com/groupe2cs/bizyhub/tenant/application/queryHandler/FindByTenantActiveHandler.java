package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindByTenantActiveQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByTenantActiveHandler {

	private final TenantRepository repository;

	@QueryHandler
	public List<TenantResponse> handle(FindByTenantActiveQuery query) {
		Boolean value = query.getActive().value();
		List<Tenant> entities = repository.findByActive(value);
		return entities.stream()
				.map(TenantMapper::toResponse)
				.toList();
	}


}
