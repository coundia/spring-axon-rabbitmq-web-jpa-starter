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
		.code(entity.getCode())
		.name(entity.getName())
		.status(entity.getStatus())
		.currency(entity.getCurrency())
		.typeAccount(entity.getTypeAccount())
		.balance(entity.getBalance())
		.balancePrev(entity.getBalancePrev())
		.balanceBlocked(entity.getBalanceBlocked())
		.balanceInit(entity.getBalanceInit())
		.balanceGoal(entity.getBalanceGoal())
		.balanceLimit(entity.getBalanceLimit())
		.description(entity.getDescription())
		.isActive(entity.getIsActive())
		.isDefault(entity.getIsDefault())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.syncAt(entity.getSyncAt())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static AccountResponse toResponse(CreateAccountCommand command) {
return AccountResponse.builder()
	.id(command.getId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.status(command.getStatus().value())
	.currency(command.getCurrency().value())
	.typeAccount(command.getTypeAccount().value())
	.balance(command.getBalance().value())
	.balancePrev(command.getBalancePrev().value())
	.balanceBlocked(command.getBalanceBlocked().value())
	.balanceInit(command.getBalanceInit().value())
	.balanceGoal(command.getBalanceGoal().value())
	.balanceLimit(command.getBalanceLimit().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.isDefault(command.getIsDefault().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.syncAt(command.getSyncAt().value())
.build();
}

public static AccountResponse toResponse(UpdateAccountCommand command) {
return AccountResponse.builder()
	.id(command.getId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.status(command.getStatus().value())
	.currency(command.getCurrency().value())
	.typeAccount(command.getTypeAccount().value())
	.balance(command.getBalance().value())
	.balancePrev(command.getBalancePrev().value())
	.balanceBlocked(command.getBalanceBlocked().value())
	.balanceInit(command.getBalanceInit().value())
	.balanceGoal(command.getBalanceGoal().value())
	.balanceLimit(command.getBalanceLimit().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.isDefault(command.getIsDefault().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.syncAt(command.getSyncAt().value())
.build();
}

public static CreateAccountCommand toCommand(
AccountRequest request
) {
return CreateAccountCommand.builder()
	.code(AccountCode.create(request.getCode()))
	.name(AccountName.create(request.getName()))
	.status(AccountStatus.create(request.getStatus()))
	.currency(AccountCurrency.create(request.getCurrency()))
	.typeAccount(AccountTypeAccount.create(request.getTypeAccount()))
	.balance(AccountBalance.create(request.getBalance()))
	.balancePrev(AccountBalancePrev.create(request.getBalancePrev()))
	.balanceBlocked(AccountBalanceBlocked.create(request.getBalanceBlocked()))
	.balanceInit(AccountBalanceInit.create(request.getBalanceInit()))
	.balanceGoal(AccountBalanceGoal.create(request.getBalanceGoal()))
	.balanceLimit(AccountBalanceLimit.create(request.getBalanceLimit()))
	.description(AccountDescription.create(request.getDescription()))
	.isActive(AccountIsActive.create(request.getIsActive()))
	.isDefault(AccountIsDefault.create(request.getIsDefault()))
	.remoteId(AccountRemoteId.create(request.getRemoteId()))
	.localId(AccountLocalId.create(request.getLocalId()))
	.syncAt(AccountSyncAt.create(request.getSyncAt()))
.build();
}

	public static UpdateAccountCommand toUpdateCommand(AccountId id, AccountRequest request) {
	return UpdateAccountCommand.builder()
	.id(id)
		.code(AccountCode.create(request.getCode()))
		.name(AccountName.create(request.getName()))
		.status(AccountStatus.create(request.getStatus()))
		.currency(AccountCurrency.create(request.getCurrency()))
		.typeAccount(AccountTypeAccount.create(request.getTypeAccount()))
		.balance(AccountBalance.create(request.getBalance()))
		.balancePrev(AccountBalancePrev.create(request.getBalancePrev()))
		.balanceBlocked(AccountBalanceBlocked.create(request.getBalanceBlocked()))
		.balanceInit(AccountBalanceInit.create(request.getBalanceInit()))
		.balanceGoal(AccountBalanceGoal.create(request.getBalanceGoal()))
		.balanceLimit(AccountBalanceLimit.create(request.getBalanceLimit()))
		.description(AccountDescription.create(request.getDescription()))
		.isActive(AccountIsActive.create(request.getIsActive()))
		.isDefault(AccountIsDefault.create(request.getIsDefault()))
		.remoteId(AccountRemoteId.create(request.getRemoteId()))
		.localId(AccountLocalId.create(request.getLocalId()))
		.syncAt(AccountSyncAt.create(request.getSyncAt()))
	.build();
	}


public static DeleteAccountCommand toDeleteCommand(AccountId id) {
return DeleteAccountCommand.builder()
.id(id)
.build();
}
}
