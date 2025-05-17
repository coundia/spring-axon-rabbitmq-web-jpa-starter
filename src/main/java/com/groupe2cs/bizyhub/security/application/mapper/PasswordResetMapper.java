package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetUsername;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;

public class PasswordResetMapper {

	public static PasswordResetResponse toResponse(PasswordReset entity) {
		return PasswordResetResponse.builder()
				.id(entity.getId())
				.token(entity.getToken())
				.username(entity.getUsername())
				.expiration(entity.getExpiration())
				.createdBy(entity.getCreatedBy().getUsername())
				.tenant(entity.getTenant().getName())
				.build();
	}

	public static PasswordResetResponse toResponse(CreatePasswordResetCommand command) {
		return PasswordResetResponse.builder()
				.id(command.getId().value())
				.token(command.getToken().value())
				.username(command.getUsername().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static PasswordResetResponse toResponse(UpdatePasswordResetCommand command) {
		return PasswordResetResponse.builder()
				.id(command.getId().value())
				.token(command.getToken().value())
				.username(command.getUsername().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static CreatePasswordResetCommand toCommand(
			PasswordResetRequest request
	) {
		return CreatePasswordResetCommand.builder()
				.token(PasswordResetToken.create(request.getToken()))
				.username(PasswordResetUsername.create(request.getUsername()))
				.expiration(PasswordResetExpiration.create(request.getExpiration()))
				.build();
	}

	public static UpdatePasswordResetCommand toUpdateCommand(PasswordResetId id, PasswordResetRequest request) {
		return UpdatePasswordResetCommand.builder()
				.id(id)
				.token(PasswordResetToken.create(request.getToken()))
				.username(PasswordResetUsername.create(request.getUsername()))
				.expiration(PasswordResetExpiration.create(request.getExpiration()))
				.build();
	}


	public static DeletePasswordResetCommand toDeleteCommand(PasswordResetId id) {
		return DeletePasswordResetCommand.builder()
				.id(id)
				.build();
	}
}
