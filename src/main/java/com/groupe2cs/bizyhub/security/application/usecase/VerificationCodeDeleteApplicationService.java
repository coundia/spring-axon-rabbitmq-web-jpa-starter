package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.VerificationCodeId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteVerificationCode(VerificationCodeId idVo, MetaRequest metaRequest) {

		DeleteVerificationCodeCommand command = new DeleteVerificationCodeCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
