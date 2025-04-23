package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenRequest;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenCreateApplicationService {
	private final CommandGateway commandGateway;

	public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request) {

		CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return RefreshTokenMapper.toResponse(command);
	}


}
