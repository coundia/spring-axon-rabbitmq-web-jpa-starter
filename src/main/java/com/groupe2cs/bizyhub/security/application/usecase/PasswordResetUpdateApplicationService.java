package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public PasswordResetResponse updatePasswordReset(PasswordResetId id, PasswordResetRequest request,
													 String createdBy
	) {

		UpdatePasswordResetCommand command = PasswordResetMapper.toUpdateCommand(
				id,
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(PasswordResetCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);

		return PasswordResetMapper.toResponse(command);
	}

}
