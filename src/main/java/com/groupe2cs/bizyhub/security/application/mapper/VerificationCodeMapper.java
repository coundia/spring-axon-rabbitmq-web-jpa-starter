package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;

public class VerificationCodeMapper {

	public static VerificationCodeResponse toResponse(VerificationCode entity) {
		return VerificationCodeResponse.builder()
				.id(entity.getId())
				.notes(entity.getNotes())
				.token(entity.getToken())
				.username(entity.getUsername())
				.phone(entity.getPhone())
				.email(entity.getEmail())
				.code(entity.getCode())
				.status(entity.getStatus())
				.source(entity.getSource())
				.expiration(entity.getExpiration())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
				.build();
	}

	public static VerificationCodeResponse toResponse(CreateVerificationCodeCommand command) {
		return VerificationCodeResponse.builder()
				.id(command.getId().value())
				.notes(command.getNotes().value())
				.token(command.getToken().value())
				.username(command.getUsername().value())
				.phone(command.getPhone().value())
				.email(command.getEmail().value())
				.code(command.getCode().value())
				.status(command.getStatus().value())
				.source(command.getSource().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static VerificationCodeResponse toResponse(UpdateVerificationCodeCommand command) {
		return VerificationCodeResponse.builder()
				.id(command.getId().value())
				.notes(command.getNotes().value())
				.token(command.getToken().value())
				.username(command.getUsername().value())
				.phone(command.getPhone().value())
				.email(command.getEmail().value())
				.code(command.getCode().value())
				.status(command.getStatus().value())
				.source(command.getSource().value())
				.expiration(command.getExpiration().value())
				.build();
	}

	public static CreateVerificationCodeCommand toCommand(
			VerificationCodeRequest request
	) {
		return CreateVerificationCodeCommand.builder()
				.notes(VerificationCodeNotes.create(request.getNotes()))
				.token(VerificationCodeToken.create(request.getToken()))
				.username(VerificationCodeUsername.create(request.getUsername()))
				.phone(VerificationCodePhone.create(request.getPhone()))
				.email(VerificationCodeEmail.create(request.getEmail()))
				.code(VerificationCodeCode.create(request.getCode()))
				.status(VerificationCodeStatus.create(request.getStatus()))
				.source(VerificationCodeSource.create(request.getSource()))
				.expiration(VerificationCodeExpiration.create(request.getExpiration()))
				.build();
	}

	public static UpdateVerificationCodeCommand toUpdateCommand(VerificationCodeId id, VerificationCodeRequest request) {
		return UpdateVerificationCodeCommand.builder()
				.id(id)
				.notes(VerificationCodeNotes.create(request.getNotes()))
				.token(VerificationCodeToken.create(request.getToken()))
				.username(VerificationCodeUsername.create(request.getUsername()))
				.phone(VerificationCodePhone.create(request.getPhone()))
				.email(VerificationCodeEmail.create(request.getEmail()))
				.code(VerificationCodeCode.create(request.getCode()))
				.status(VerificationCodeStatus.create(request.getStatus()))
				.source(VerificationCodeSource.create(request.getSource()))
				.expiration(VerificationCodeExpiration.create(request.getExpiration()))
				.build();
	}


	public static DeleteVerificationCodeCommand toDeleteCommand(VerificationCodeId id) {
		return DeleteVerificationCodeCommand.builder()
				.id(id)
				.build();
	}
}
