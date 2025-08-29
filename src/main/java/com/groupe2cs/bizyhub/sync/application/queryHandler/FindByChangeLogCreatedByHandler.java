package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.ChangeLogMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindByChangeLogCreatedByQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByChangeLogCreatedByHandler {

	private final ChangeLogRepository repository;

	@QueryHandler
	public List<ChangeLogResponse> handle(FindByChangeLogCreatedByQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<ChangeLog> entities = null;
		String value = query.getCreatedBy().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCreatedByIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCreatedByIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ChangeLogMapper::toResponse)
				.toList();
	}


}
