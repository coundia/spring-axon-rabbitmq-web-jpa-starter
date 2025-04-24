package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeyUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public ApiKeyResponse updateApiKey(ApiKeyId id, ApiKeyRequest request,
									   String createdBy
	) {

		UpdateApiKeyCommand command = ApiKeyMapper.toUpdateCommand(
				id,
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(ApiKeyCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);

		return ApiKeyMapper.toResponse(command);
	}

}
