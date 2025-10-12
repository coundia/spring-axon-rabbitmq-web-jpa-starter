package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindBySyncStateCreatedByQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySyncStateCreatedByHandler {

	private final SyncStateRepository repository;

	@QueryHandler
	public List<SyncStateResponse> handle(FindBySyncStateCreatedByQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<SyncState> entities = null;
		String value = query.getCreatedBy().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCreatedByIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCreatedByIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SyncStateMapper::toResponse)
				.toList();
	}


}
