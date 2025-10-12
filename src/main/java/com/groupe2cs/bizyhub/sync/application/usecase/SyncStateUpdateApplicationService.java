package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.sync.application.command.UpdateSyncStateCommand;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateCreatedBy;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateId;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SyncStateUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public SyncStateResponse updateSyncState(SyncStateId id, SyncStateRequest request,
											 MetaRequest metaRequest
	) {

		UpdateSyncStateCommand command = SyncStateMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(SyncStateCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(SyncStateTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return SyncStateMapper.toResponse(command);
	}

}
