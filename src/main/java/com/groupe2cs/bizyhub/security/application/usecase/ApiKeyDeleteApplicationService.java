package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeyDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteApiKey(ApiKeyId idVo, MetaRequest metaRequest) {

		DeleteApiKeyCommand command = new DeleteApiKeyCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
