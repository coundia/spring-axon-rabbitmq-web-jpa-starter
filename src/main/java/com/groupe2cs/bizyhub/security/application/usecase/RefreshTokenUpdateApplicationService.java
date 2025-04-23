package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenRequest;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RefreshTokenMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public RefreshTokenResponse updateRefreshToken(RefreshTokenId id, RefreshTokenRequest request) {

		UpdateRefreshTokenCommand command = RefreshTokenMapper.toUpdateCommand(
				id,
				request
		);

		commandGateway.sendAndWait(command);

		return RefreshTokenMapper.toResponse(command);
	}

}
