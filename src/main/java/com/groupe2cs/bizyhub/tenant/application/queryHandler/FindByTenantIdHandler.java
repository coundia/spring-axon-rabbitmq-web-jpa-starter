package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindByTenantIdQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByTenantIdHandler {

	private final TenantRepository repository;

	@QueryHandler

	public TenantResponse handle(FindByTenantIdQuery query) {
		String value = query.getId().value();
		Tenant entity = repository.findById(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return TenantMapper.toResponse(entity);
	}

}
