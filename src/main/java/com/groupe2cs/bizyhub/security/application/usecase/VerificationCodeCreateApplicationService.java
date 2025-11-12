package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.mapper.VerificationCodeMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeCreateApplicationService {
	private final CommandGateway commandGateway;

	public VerificationCodeResponse createVerificationCode(VerificationCodeRequest request,
														   MetaRequest metaRequest
	) {

		CreateVerificationCodeCommand command = VerificationCodeMapper.toCommand(
				request
		);

		command.setCreatedBy(VerificationCodeCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(VerificationCodeTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return VerificationCodeMapper.toResponse(command);
	}


}
