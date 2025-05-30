package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
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
													 MetaRequest metaRequest
	) {

		UpdatePasswordResetCommand command = PasswordResetMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(PasswordResetCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(PasswordResetTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return PasswordResetMapper.toResponse(command);
	}

}
