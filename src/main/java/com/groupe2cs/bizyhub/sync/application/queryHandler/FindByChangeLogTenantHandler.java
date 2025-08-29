package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.ChangeLogMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindByChangeLogTenantQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByChangeLogTenantHandler {

	private final ChangeLogRepository repository;

	@QueryHandler
	public List<ChangeLogResponse> handle(FindByChangeLogTenantQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<ChangeLog> entities = null;
		String value = query.getTenant().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTenantIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTenantIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ChangeLogMapper::toResponse)
				.toList();
	}


}
