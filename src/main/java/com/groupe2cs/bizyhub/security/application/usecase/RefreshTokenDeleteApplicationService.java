package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteRefreshToken(RefreshTokenId idVo) {

		DeleteRefreshTokenCommand command = new DeleteRefreshTokenCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
