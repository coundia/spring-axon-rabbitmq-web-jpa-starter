package com.groupe2cs.bizyhub.sync.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStatePagedResponse;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.application.query.FindAllSyncStateQuery;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllSyncStateQueryHandler {

	private final SyncStateRepository repository;

	public FindAllSyncStateQueryHandler(SyncStateRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public SyncStatePagedResponse handle(FindAllSyncStateQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<SyncState> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all SyncStates");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<SyncStateResponse> responses = pages.stream()
				.map(SyncStateMapper::toResponse)
				.toList();

		return SyncStatePagedResponse.from(
				pages,
				responses
		);
	}
}
