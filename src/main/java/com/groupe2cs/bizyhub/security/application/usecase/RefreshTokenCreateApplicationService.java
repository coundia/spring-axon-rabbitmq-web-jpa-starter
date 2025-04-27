package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenRequest;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenCreateApplicationService {
	private final CommandGateway commandGateway;

	public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request,
												   MetaRequest metaRequest
	) {

		CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
				request
		);

		command.setCreatedBy(RefreshTokenCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(RefreshTokenTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return RefreshTokenMapper.toResponse(command);
	}


}
