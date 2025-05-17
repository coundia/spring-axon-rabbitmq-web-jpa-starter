package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindByTenantCreatedByQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTenantCreatedByHandler {

	private final TenantRepository repository;

	@QueryHandler
	public List<TenantResponse> handle(FindByTenantCreatedByQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Tenant> entities = null;
		String value = query.getCreatedBy().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCreatedByIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCreatedByIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TenantMapper::toResponse)
				.toList();
	}


}
