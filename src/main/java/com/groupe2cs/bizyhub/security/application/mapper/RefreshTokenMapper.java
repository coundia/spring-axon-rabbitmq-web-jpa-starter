package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenRequest;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenUsername;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;

public class RefreshTokenMapper {

	public static RefreshTokenResponse toResponse(RefreshToken entity) {
		return RefreshTokenResponse.builder()
				.id(entity.getId())
				.token(entity.getToken())
				.username(entity.getUsername())
				.expiration(entity.getExpiration())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
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
