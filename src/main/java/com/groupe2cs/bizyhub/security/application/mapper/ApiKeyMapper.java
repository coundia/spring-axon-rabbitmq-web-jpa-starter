package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;


public class ApiKeyMapper {

	public static ApiKeyResponse toResponse(ApiKey entity) {
		return new ApiKeyResponse(
				entity.getId(),
				entity.getKey(),
				entity.getUsername(),
				entity.getCreatedAt(),
				entity.getExpiration()
		);
	}

	public static ApiKeyResponse toResponse(CreateApiKeyCommand command) {
		return new ApiKeyResponse(
				command.getId().value(),
				command.getKey().value(),
				command.getUsername().value(),
				command.getCreatedAt().value(),
				command.getExpiration().value()
		);
	}

	public static ApiKeyResponse toResponse(UpdateApiKeyCommand command) {
		return new ApiKeyResponse(
				command.getId().value(),
				command.getKey().value(),
				command.getUsername().value(),
				command.getCreatedAt().value(),
				command.getExpiration().value()
		);
	}


	public static CreateApiKeyCommand toCommand(
			ApiKeyRequest request
	) {
		return new CreateApiKeyCommand(
				ApiKeyKey.create(request.getKey()),
				ApiKeyUsername.create(request.getUsername()),
				ApiKeyCreatedAt.create(request.getCreatedAt()),
				ApiKeyExpiration.create(request.getExpiration())
		);
	}

	public static UpdateApiKeyCommand toUpdateCommand(ApiKeyId id, ApiKeyRequest request) {
		return new UpdateApiKeyCommand(
				id,
				ApiKeyKey.create(request.getKey()),
				ApiKeyUsername.create(request.getUsername()),
				ApiKeyCreatedAt.create(request.getCreatedAt()),
				ApiKeyExpiration.create(request.getExpiration())
		);
	}


	public static DeleteApiKeyCommand toDeleteCommand(ApiKeyId id) {
		return new DeleteApiKeyCommand(id);
	}
}
