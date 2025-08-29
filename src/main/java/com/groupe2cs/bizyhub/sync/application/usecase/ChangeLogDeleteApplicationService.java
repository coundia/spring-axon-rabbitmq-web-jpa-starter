package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.command.DeleteChangeLogCommand;
import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeLogDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteChangeLog(ChangeLogId idVo, MetaRequest metaRequest) {

		DeleteChangeLogCommand command = new DeleteChangeLogCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
