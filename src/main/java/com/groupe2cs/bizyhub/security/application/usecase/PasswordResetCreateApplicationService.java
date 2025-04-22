package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetCreateApplicationService {
	private final CommandGateway commandGateway;

	public PasswordResetResponse createPasswordReset(PasswordResetRequest request) {

		CreatePasswordResetCommand command = PasswordResetMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return PasswordResetMapper.toResponse(command);
	}


}
