package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PasswordResetMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetCreateApplicationService {
	private final CommandGateway commandGateway;

	public PasswordResetResponse createPasswordReset(PasswordResetRequest request,
													 MetaRequest metaRequest
	) {

		CreatePasswordResetCommand command = PasswordResetMapper.toCommand(
				request
		);

		command.setCreatedBy(PasswordResetCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(PasswordResetTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return PasswordResetMapper.toResponse(command);
	}


}
