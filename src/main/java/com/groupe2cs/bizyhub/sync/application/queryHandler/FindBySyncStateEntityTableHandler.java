package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindBySyncStateEntityTableQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySyncStateEntityTableHandler {

	private final SyncStateRepository repository;

	@QueryHandler
	public List<SyncStateResponse> handle(FindBySyncStateEntityTableQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<SyncState> entities = null;
		String value = query.getEntityTable().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByEntityTableAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByEntityTableAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SyncStateMapper::toResponse)
				.toList();
	}


}
