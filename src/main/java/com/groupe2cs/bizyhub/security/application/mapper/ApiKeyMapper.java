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
		return ApiKeyResponse.builder()
				.id(entity.getId())
				.appKey(entity.getAppKey())
				.username(entity.getUsername())
				.createdAt(entity.getCreatedAt())
				.expiration(entity.getExpiration())
				.build();
	}

	public static ApiKeyResponse toResponse(CreateApiKeyCommand command) {
		return ApiKeyResponse.builder()
				.id(command.getId().value())
				.appKey(command.getAppKey().value())
				.username(command.getUsername().value())
				.createdAt(command.getCreatedAt().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static ApiKeyResponse toResponse(UpdateApiKeyCommand command) {
		return ApiKeyResponse.builder()
				.id(command.getId().value())
				.appKey(command.getAppKey().value())
				.username(command.getUsername().value())
				.createdAt(command.getCreatedAt().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static CreateApiKeyCommand toCommand(
			ApiKeyRequest request
	) {
		return CreateApiKeyCommand.builder()
				.appKey(ApiKeyAppKey.create(request.getAppKey()))
				.username(ApiKeyUsername.create(request.getUsername()))
				.createdAt(ApiKeyCreatedAt.create(request.getCreatedAt()))
				.expiration(ApiKeyExpiration.create(request.getExpiration()))
				.build();
	}

	public static UpdateApiKeyCommand toUpdateCommand(ApiKeyId id, ApiKeyRequest request) {
		return UpdateApiKeyCommand.builder()
				.id(id)
				.appKey(ApiKeyAppKey.create(request.getAppKey()))
				.username(ApiKeyUsername.create(request.getUsername()))
				.createdAt(ApiKeyCreatedAt.create(request.getCreatedAt()))
				.expiration(ApiKeyExpiration.create(request.getExpiration()))
				.build();
	}


	public static DeleteApiKeyCommand toDeleteCommand(ApiKeyId id) {
		return DeleteApiKeyCommand.builder()
				.id(id)
				.build();
	}
}
