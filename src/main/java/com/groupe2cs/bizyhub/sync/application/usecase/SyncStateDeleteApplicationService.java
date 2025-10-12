package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.command.DeleteSyncStateCommand;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SyncStateDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteSyncState(SyncStateId idVo, MetaRequest metaRequest) {

		DeleteSyncStateCommand command = new DeleteSyncStateCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
