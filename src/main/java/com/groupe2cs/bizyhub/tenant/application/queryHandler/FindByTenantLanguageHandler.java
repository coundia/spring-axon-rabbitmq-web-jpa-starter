package com.groupe2cs.bizyhub.tenant.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.application.query.FindByTenantLanguageQuery;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTenantLanguageHandler {

	private final TenantRepository repository;

	@QueryHandler
	public List<TenantResponse> handle(FindByTenantLanguageQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Tenant> entities = null;
		String value = query.getLanguage().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByLanguageAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByLanguageAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TenantMapper::toResponse)
				.toList();
	}


}
