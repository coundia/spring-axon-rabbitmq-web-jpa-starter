package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class RefreshTokenMapper {

public static RefreshTokenResponse toResponse(RefreshToken entity) {
return RefreshTokenResponse.builder()
		.id(entity.getId())
		.token(entity.getToken())
		.username(entity.getUsername())
		.expiration(entity.getExpiration())
    .createdBy(entity.getCreatedBy().getUsername())
    .tenant(entity.getTenant().getName())
.build();
}

public static RefreshTokenResponse toResponse(CreateRefreshTokenCommand command) {
return RefreshTokenResponse.builder()
	.id(command.getId().value())
	.token(command.getToken().value())
	.username(command.getUsername().value())
	.expiration(command.getExpiration().value())
.build();
}

public static RefreshTokenResponse toResponse(UpdateRefreshTokenCommand command) {
return RefreshTokenResponse.builder()
	.id(command.getId().value())
	.token(command.getToken().value())
	.username(command.getUsername().value())
	.expiration(command.getExpiration().value())
.build();
}

public static CreateRefreshTokenCommand toCommand(
RefreshTokenRequest request
) {
return CreateRefreshTokenCommand.builder()
	.token(RefreshTokenToken.create(request.getToken()))
	.username(RefreshTokenUsername.create(request.getUsername()))
	.expiration(RefreshTokenExpiration.create(request.getExpiration()))
.build();
}

	public static UpdateRefreshTokenCommand toUpdateCommand(RefreshTokenId id, RefreshTokenRequest request) {
	return UpdateRefreshTokenCommand.builder()
	.id(id)
		.token(RefreshTokenToken.create(request.getToken()))
		.username(RefreshTokenUsername.create(request.getUsername()))
		.expiration(RefreshTokenExpiration.create(request.getExpiration()))
	.build();
	}


public static DeleteRefreshTokenCommand toDeleteCommand(RefreshTokenId id) {
return DeleteRefreshTokenCommand.builder()
.id(id)
.build();
}
}
