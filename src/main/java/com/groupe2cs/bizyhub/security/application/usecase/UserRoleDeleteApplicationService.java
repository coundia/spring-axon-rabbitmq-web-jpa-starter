package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteUserRoleCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteUserRole(UserRoleId idVo, MetaRequest metaRequest) {

		DeleteUserRoleCommand command = new DeleteUserRoleCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
