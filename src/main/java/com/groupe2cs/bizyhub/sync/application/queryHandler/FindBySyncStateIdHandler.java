package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindBySyncStateIdQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindBySyncStateIdHandler {

	private final SyncStateRepository repository;

	@QueryHandler

	public SyncStateResponse handle(FindBySyncStateIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		SyncState entity = null;

		String value = query.getId().value();

		if (metaRequest.isAdmin()) {
			entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
					.stream()
					.findFirst()
					.orElse(null);
		} else {
			entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
					.stream()
					.findFirst()
					.orElse(null);
		}

		if (entity == null) {
			return null;
		}
		return SyncStateMapper.toResponse(entity);
	}

}
