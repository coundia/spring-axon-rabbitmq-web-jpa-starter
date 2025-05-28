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
		.username(entity.getUsername())
		.details(entity.getDetails())
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
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
.build();
}

public static AccountUserResponse toResponse(UpdateAccountUserCommand command) {
return AccountUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.account(command.getAccount().value())
	.user(command.getUser().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
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
	.username(AccountUserUsername.create(request.getUsername()))
	.details(AccountUserDetails.create(request.getDetails()))
	.isActive(AccountUserIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateAccountUserCommand toUpdateCommand(AccountUserId id, AccountUserRequest request) {
	return UpdateAccountUserCommand.builder()
	.id(id)
		.name(AccountUserName.create(request.getName()))
		.account(AccountUserAccount.create(request.getAccount()))
		.user(AccountUserUser.create(request.getUser()))
		.username(AccountUserUsername.create(request.getUsername()))
		.details(AccountUserDetails.create(request.getDetails()))
		.isActive(AccountUserIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteAccountUserCommand toDeleteCommand(AccountUserId id) {
return DeleteAccountUserCommand.builder()
.id(id)
.build();
}
}
