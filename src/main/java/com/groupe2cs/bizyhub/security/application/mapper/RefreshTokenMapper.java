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
		return new RefreshTokenResponse(
				entity.getId(),
				entity.getToken(),
				entity.getUsername(),
				entity.getExpiration()
		);
	}

	public static RefreshTokenResponse toResponse(CreateRefreshTokenCommand command) {
		return new RefreshTokenResponse(
				command.getId().value(),
				command.getToken().value(),
				command.getUsername().value(),
				command.getExpiration().value()
		);
	}

	public static RefreshTokenResponse toResponse(UpdateRefreshTokenCommand command) {
		return new RefreshTokenResponse(
				command.getId().value(),
				command.getToken().value(),
				command.getUsername().value(),
				command.getExpiration().value()
		);
	}


	public static CreateRefreshTokenCommand toCommand(
			RefreshTokenRequest request
	) {
		return new CreateRefreshTokenCommand(
				RefreshTokenToken.create(request.getToken()),
				RefreshTokenUsername.create(request.getUsername()),
				RefreshTokenExpiration.create(request.getExpiration())
		);
	}

	public static UpdateRefreshTokenCommand toUpdateCommand(RefreshTokenId id, RefreshTokenRequest request) {
		return new UpdateRefreshTokenCommand(
				id,
				RefreshTokenToken.create(request.getToken()),
				RefreshTokenUsername.create(request.getUsername()),
				RefreshTokenExpiration.create(request.getExpiration())
		);
	}


	public static DeleteRefreshTokenCommand toDeleteCommand(RefreshTokenId id) {
		return new DeleteRefreshTokenCommand(id);
	}
}
