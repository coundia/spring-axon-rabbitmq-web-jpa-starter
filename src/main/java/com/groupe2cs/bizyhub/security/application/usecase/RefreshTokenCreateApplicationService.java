package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenRequest;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenCreatedBy;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenCreateApplicationService {
	private final CommandGateway commandGateway;

	public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request,
												   String createdBy) {

		CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(RefreshTokenCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);
		return RefreshTokenMapper.toResponse(command);
	}


}
