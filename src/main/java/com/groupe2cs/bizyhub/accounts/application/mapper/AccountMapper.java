package com.groupe2cs.bizyhub.accounts.application.mapper;

	import com.groupe2cs.bizyhub.accounts.application.dto.*;
	import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
	import com.groupe2cs.bizyhub.accounts.domain.*;
	import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.accounts.application.command.*;

public class AccountMapper {

public static AccountResponse toResponse(Account entity) {
return AccountResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.currency(entity.getCurrency())
		.currentBalance(entity.getCurrentBalance())
		.previousBalance(entity.getPreviousBalance())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static AccountResponse toResponse(CreateAccountCommand command) {
return AccountResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.currency(command.getCurrency().value())
	.currentBalance(command.getCurrentBalance().value())
	.previousBalance(command.getPreviousBalance().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
.build();
}

public static AccountResponse toResponse(UpdateAccountCommand command) {
return AccountResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.currency(command.getCurrency().value())
	.currentBalance(command.getCurrentBalance().value())
	.previousBalance(command.getPreviousBalance().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateAccountCommand toCommand(
AccountRequest request
) {
return CreateAccountCommand.builder()
	.name(AccountName.create(request.getName()))
	.currency(AccountCurrency.create(request.getCurrency()))
	.currentBalance(AccountCurrentBalance.create(request.getCurrentBalance()))
	.previousBalance(AccountPreviousBalance.create(request.getPreviousBalance()))
	.details(AccountDetails.create(request.getDetails()))
	.isActive(AccountIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateAccountCommand toUpdateCommand(AccountId id, AccountRequest request) {
	return UpdateAccountCommand.builder()
	.id(id)
		.name(AccountName.create(request.getName()))
		.currency(AccountCurrency.create(request.getCurrency()))
		.currentBalance(AccountCurrentBalance.create(request.getCurrentBalance()))
		.previousBalance(AccountPreviousBalance.create(request.getPreviousBalance()))
		.details(AccountDetails.create(request.getDetails()))
		.isActive(AccountIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteAccountCommand toDeleteCommand(AccountId id) {
return DeleteAccountCommand.builder()
.id(id)
.build();
}
}
