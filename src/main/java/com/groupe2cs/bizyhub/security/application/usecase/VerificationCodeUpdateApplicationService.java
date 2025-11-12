package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.mapper.VerificationCodeMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeId;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public VerificationCodeResponse updateVerificationCode(VerificationCodeId id, VerificationCodeRequest request,
														   MetaRequest metaRequest
	) {

		UpdateVerificationCodeCommand command = VerificationCodeMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(VerificationCodeCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(VerificationCodeTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return VerificationCodeMapper.toResponse(command);
	}

}
