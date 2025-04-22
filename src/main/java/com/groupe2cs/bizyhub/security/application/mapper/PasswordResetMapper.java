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
		return new PasswordResetResponse(
				entity.getId(),
				entity.getToken(),
				entity.getUsername(),
				entity.getExpiration()
		);
	}

	public static PasswordResetResponse toResponse(CreatePasswordResetCommand command) {
		return new PasswordResetResponse(
				command.getId().value(),
				command.getToken().value(),
				command.getUsername().value(),
				command.getExpiration().value()
		);
	}

	public static PasswordResetResponse toResponse(UpdatePasswordResetCommand command) {
		return new PasswordResetResponse(
				command.getId().value(),
				command.getToken().value(),
				command.getUsername().value(),
				command.getExpiration().value()
		);
	}


	public static CreatePasswordResetCommand toCommand(
			PasswordResetRequest request
	) {
		return new CreatePasswordResetCommand(
				PasswordResetToken.create(request.getToken()),
				PasswordResetUsername.create(request.getUsername()),
				PasswordResetExpiration.create(request.getExpiration())
		);
	}

	public static UpdatePasswordResetCommand toUpdateCommand(PasswordResetId id, PasswordResetRequest request) {
		return new UpdatePasswordResetCommand(
				id,
				PasswordResetToken.create(request.getToken()),
				PasswordResetUsername.create(request.getUsername()),
				PasswordResetExpiration.create(request.getExpiration())
		);
	}


	public static DeletePasswordResetCommand toDeleteCommand(PasswordResetId id) {
		return new DeletePasswordResetCommand(id);
	}
}
