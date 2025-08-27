package com.groupe2cs.bizyhub.accounts.application.mapper;

	import com.groupe2cs.bizyhub.accounts.application.dto.*;
	import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
	import com.groupe2cs.bizyhub.accounts.domain.*;
	import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.accounts.application.command.*;

public class AccountUserMapper {

public static AccountUserResponse toResponse(AccountUser entity) {
return AccountUserResponse.builder()
		.id(entity.getId())
		.account(entity.getAccount())
		.user(entity.getUser())
		.phone(entity.getPhone())
		.role(entity.getRole())
		.status(entity.getStatus())
		.invitedBy(entity.getInvitedBy())
		.syncAt(entity.getSyncAt())
		.acceptedAt(entity.getAcceptedAt())
		.revokedAt(entity.getRevokedAt())
		.message(entity.getMessage())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.isActive(entity.getIsActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static AccountUserResponse toResponse(CreateAccountUserCommand command) {
return AccountUserResponse.builder()
	.id(command.getId().value())
	.account(command.getAccount().value())
	.user(command.getUser().value())
	.phone(command.getPhone().value())
	.role(command.getRole().value())
	.status(command.getStatus().value())
	.invitedBy(command.getInvitedBy().value())
	.syncAt(command.getSyncAt().value())
	.acceptedAt(command.getAcceptedAt().value())
	.revokedAt(command.getRevokedAt().value())
	.message(command.getMessage().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.isActive(command.getIsActive().value())
.build();
}

public static AccountUserResponse toResponse(UpdateAccountUserCommand command) {
return AccountUserResponse.builder()
	.id(command.getId().value())
	.account(command.getAccount().value())
	.user(command.getUser().value())
	.phone(command.getPhone().value())
	.role(command.getRole().value())
	.status(command.getStatus().value())
	.invitedBy(command.getInvitedBy().value())
	.syncAt(command.getSyncAt().value())
	.acceptedAt(command.getAcceptedAt().value())
	.revokedAt(command.getRevokedAt().value())
	.message(command.getMessage().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateAccountUserCommand toCommand(
AccountUserRequest request
) {
return CreateAccountUserCommand.builder()
	.account(AccountUserAccount.create(request.getAccount()))
	.user(AccountUserUser.create(request.getUser()))
	.phone(AccountUserPhone.create(request.getPhone()))
	.role(AccountUserRole.create(request.getRole()))
	.status(AccountUserStatus.create(request.getStatus()))
	.invitedBy(AccountUserInvitedBy.create(request.getInvitedBy()))
	.syncAt(AccountUserSyncAt.create(request.getSyncAt()))
	.acceptedAt(AccountUserAcceptedAt.create(request.getAcceptedAt()))
	.revokedAt(AccountUserRevokedAt.create(request.getRevokedAt()))
	.message(AccountUserMessage.create(request.getMessage()))
	.remoteId(AccountUserRemoteId.create(request.getRemoteId()))
	.localId(AccountUserLocalId.create(request.getLocalId()))
	.isActive(AccountUserIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateAccountUserCommand toUpdateCommand(AccountUserId id, AccountUserRequest request) {
	return UpdateAccountUserCommand.builder()
	.id(id)
		.account(AccountUserAccount.create(request.getAccount()))
		.user(AccountUserUser.create(request.getUser()))
		.phone(AccountUserPhone.create(request.getPhone()))
		.role(AccountUserRole.create(request.getRole()))
		.status(AccountUserStatus.create(request.getStatus()))
		.invitedBy(AccountUserInvitedBy.create(request.getInvitedBy()))
		.syncAt(AccountUserSyncAt.create(request.getSyncAt()))
		.acceptedAt(AccountUserAcceptedAt.create(request.getAcceptedAt()))
		.revokedAt(AccountUserRevokedAt.create(request.getRevokedAt()))
		.message(AccountUserMessage.create(request.getMessage()))
		.remoteId(AccountUserRemoteId.create(request.getRemoteId()))
		.localId(AccountUserLocalId.create(request.getLocalId()))
		.isActive(AccountUserIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteAccountUserCommand toDeleteCommand(AccountUserId id) {
return DeleteAccountUserCommand.builder()
.id(id)
.build();
}
}
