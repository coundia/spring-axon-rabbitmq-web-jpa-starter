package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteRefreshToken(RefreshTokenId idVo, MetaRequest metaRequest) {

		DeleteRefreshTokenCommand command = new DeleteRefreshTokenCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
