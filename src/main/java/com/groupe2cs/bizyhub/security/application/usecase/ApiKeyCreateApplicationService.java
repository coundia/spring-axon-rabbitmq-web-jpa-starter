package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeyCreateApplicationService {
	private final CommandGateway commandGateway;

	public ApiKeyResponse createApiKey(ApiKeyRequest request,
									   MetaRequest metaRequest
	) {

		CreateApiKeyCommand command = ApiKeyMapper.toCommand(
				request
		);

		command.setCreatedBy(ApiKeyCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ApiKeyTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return ApiKeyMapper.toResponse(command);
	}


}
