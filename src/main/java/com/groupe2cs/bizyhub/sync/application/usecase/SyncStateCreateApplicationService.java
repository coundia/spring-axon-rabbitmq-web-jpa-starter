package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.command.CreateSyncStateCommand;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateRequest;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.SyncStateMapper;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateCreatedBy;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SyncStateCreateApplicationService {
	private final CommandGateway commandGateway;

	public SyncStateResponse createSyncState(SyncStateRequest request,
											 MetaRequest metaRequest
	) {

		CreateSyncStateCommand command = SyncStateMapper.toCommand(
				request
		);

		command.setCreatedBy(SyncStateCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(SyncStateTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return SyncStateMapper.toResponse(command);
	}


}
