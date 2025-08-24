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
		.name(entity.getName())
		.account(entity.getAccount() != null ? entity.getAccount().getId() : null)
		.user(entity.getUser() != null ? entity.getUser().getId() : null)
		.syncAt(entity.getSyncAt())
		.username(entity.getUsername())
		.details(entity.getDetails())
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
	.name(command.getName().value())
	.account(command.getAccount().value())
	.user(command.getUser().value())
	.syncAt(command.getSyncAt().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.isActive(command.getIsActive().value())
.build();
}

public static AccountUserResponse toResponse(UpdateAccountUserCommand command) {
return AccountUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.account(command.getAccount().value())
	.user(command.getUser().value())
	.syncAt(command.getSyncAt().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateAccountUserCommand toCommand(
AccountUserRequest request
) {
return CreateAccountUserCommand.builder()
	.name(AccountUserName.create(request.getName()))
	.account(AccountUserAccount.create(request.getAccount()))
	.user(AccountUserUser.create(request.getUser()))
	.syncAt(AccountUserSyncAt.create(request.getSyncAt()))
	.username(AccountUserUsername.create(request.getUsername()))
	.details(AccountUserDetails.create(request.getDetails()))
	.remoteId(AccountUserRemoteId.create(request.getRemoteId()))
	.localId(AccountUserLocalId.create(request.getLocalId()))
	.isActive(AccountUserIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateAccountUserCommand toUpdateCommand(AccountUserId id, AccountUserRequest request) {
	return UpdateAccountUserCommand.builder()
	.id(id)
		.name(AccountUserName.create(request.getName()))
		.account(AccountUserAccount.create(request.getAccount()))
		.user(AccountUserUser.create(request.getUser()))
		.syncAt(AccountUserSyncAt.create(request.getSyncAt()))
		.username(AccountUserUsername.create(request.getUsername()))
		.details(AccountUserDetails.create(request.getDetails()))
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
