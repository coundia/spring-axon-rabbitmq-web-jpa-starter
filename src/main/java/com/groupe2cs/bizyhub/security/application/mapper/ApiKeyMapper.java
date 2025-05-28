package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class ApiKeyMapper {

public static ApiKeyResponse toResponse(ApiKey entity) {
return ApiKeyResponse.builder()
		.id(entity.getId())
		.appKey(entity.getAppKey())
		.username(entity.getUsername())
		.active(entity.getActive())
		.expiration(entity.getExpiration())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static ApiKeyResponse toResponse(CreateApiKeyCommand command) {
return ApiKeyResponse.builder()
	.id(command.getId().value())
	.appKey(command.getAppKey().value())
	.username(command.getUsername().value())
	.active(command.getActive().value())
	.expiration(command.getExpiration().value())
.build();
}

public static ApiKeyResponse toResponse(UpdateApiKeyCommand command) {
return ApiKeyResponse.builder()
	.id(command.getId().value())
	.appKey(command.getAppKey().value())
	.username(command.getUsername().value())
	.active(command.getActive().value())
	.expiration(command.getExpiration().value())
.build();
}

public static CreateApiKeyCommand toCommand(
ApiKeyRequest request
) {
return CreateApiKeyCommand.builder()
	.appKey(ApiKeyAppKey.create(request.getAppKey()))
	.username(ApiKeyUsername.create(request.getUsername()))
	.active(ApiKeyActive.create(request.getActive()))
	.expiration(ApiKeyExpiration.create(request.getExpiration()))
.build();
}

	public static UpdateApiKeyCommand toUpdateCommand(ApiKeyId id, ApiKeyRequest request) {
	return UpdateApiKeyCommand.builder()
	.id(id)
		.appKey(ApiKeyAppKey.create(request.getAppKey()))
		.username(ApiKeyUsername.create(request.getUsername()))
		.active(ApiKeyActive.create(request.getActive()))
		.expiration(ApiKeyExpiration.create(request.getExpiration()))
	.build();
	}


public static DeleteApiKeyCommand toDeleteCommand(ApiKeyId id) {
return DeleteApiKeyCommand.builder()
.id(id)
.build();
}
}
