package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetCreatedBy;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetCreateApplicationService {
	private final CommandGateway commandGateway;

	public PasswordResetResponse createPasswordReset(PasswordResetRequest request,
													 String createdBy) {

		CreatePasswordResetCommand command = PasswordResetMapper.toCommand(
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(PasswordResetCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);
		return PasswordResetMapper.toResponse(command);
	}


}
