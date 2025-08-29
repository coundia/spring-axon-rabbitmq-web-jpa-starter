package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindBySyncStateAccountQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySyncStateAccountHandler {

	private final SyncStateRepository repository;

	@QueryHandler
	public List<SyncStateResponse> handle(FindBySyncStateAccountQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<SyncState> entities = null;
		String value = query.getAccount().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByAccountAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByAccountAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SyncStateMapper::toResponse)
				.toList();
	}


}
