package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeletePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deletePermission(PermissionId idVo, MetaRequest metaRequest) {

		DeletePermissionCommand command = new DeletePermissionCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
