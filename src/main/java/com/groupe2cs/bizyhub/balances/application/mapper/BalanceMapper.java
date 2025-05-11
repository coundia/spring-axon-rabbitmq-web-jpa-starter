package com.groupe2cs.bizyhub.balances.application.mapper;

	import com.groupe2cs.bizyhub.balances.application.dto.*;
	import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
	import com.groupe2cs.bizyhub.balances.domain.*;
	import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.balances.application.command.*;

public class BalanceMapper {

public static BalanceResponse toResponse(Balance entity) {
return BalanceResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.currency(entity.getCurrency())
		.currentBalance(entity.getCurrentBalance())
		.previousBalance(entity.getPreviousBalance())
		.lastUpdated(entity.getLastUpdated())
		.isDefault(entity.getIsDefault())
		.ordre(entity.getOrdre())
		.isArchived(entity.getIsArchived())
		.isAllowDebit(entity.getIsAllowDebit())
		.isAllowCredit(entity.getIsAllowCredit())
		.isExcluTotal(entity.getIsExcluTotal())
		.activateNotification(entity.getActivateNotification())
		.syncedAt(entity.getSyncedAt())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static BalanceResponse toResponse(CreateBalanceCommand command) {
return BalanceResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.currency(command.getCurrency().value())
	.currentBalance(command.getCurrentBalance().value())
	.previousBalance(command.getPreviousBalance().value())
	.lastUpdated(command.getLastUpdated().value())
	.isDefault(command.getIsDefault().value())
	.ordre(command.getOrdre().value())
	.isArchived(command.getIsArchived().value())
	.isAllowDebit(command.getIsAllowDebit().value())
	.isAllowCredit(command.getIsAllowCredit().value())
	.isExcluTotal(command.getIsExcluTotal().value())
	.activateNotification(command.getActivateNotification().value())
	.syncedAt(command.getSyncedAt().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static BalanceResponse toResponse(UpdateBalanceCommand command) {
return BalanceResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.currency(command.getCurrency().value())
	.currentBalance(command.getCurrentBalance().value())
	.previousBalance(command.getPreviousBalance().value())
	.lastUpdated(command.getLastUpdated().value())
	.isDefault(command.getIsDefault().value())
	.ordre(command.getOrdre().value())
	.isArchived(command.getIsArchived().value())
	.isAllowDebit(command.getIsAllowDebit().value())
	.isAllowCredit(command.getIsAllowCredit().value())
	.isExcluTotal(command.getIsExcluTotal().value())
	.activateNotification(command.getActivateNotification().value())
	.syncedAt(command.getSyncedAt().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateBalanceCommand toCommand(
BalanceRequest request
) {
return CreateBalanceCommand.builder()
	.name(BalanceName.create(request.getName()))
	.currency(BalanceCurrency.create(request.getCurrency()))
	.currentBalance(BalanceCurrentBalance.create(request.getCurrentBalance()))
	.previousBalance(BalancePreviousBalance.create(request.getPreviousBalance()))
	.lastUpdated(BalanceLastUpdated.create(request.getLastUpdated()))
	.isDefault(BalanceIsDefault.create(request.getIsDefault()))
	.ordre(BalanceOrdre.create(request.getOrdre()))
	.isArchived(BalanceIsArchived.create(request.getIsArchived()))
	.isAllowDebit(BalanceIsAllowDebit.create(request.getIsAllowDebit()))
	.isAllowCredit(BalanceIsAllowCredit.create(request.getIsAllowCredit()))
	.isExcluTotal(BalanceIsExcluTotal.create(request.getIsExcluTotal()))
	.activateNotification(BalanceActivateNotification.create(request.getActivateNotification()))
	.syncedAt(BalanceSyncedAt.create(request.getSyncedAt()))
	.updatedAt(BalanceUpdatedAt.create(request.getUpdatedAt()))
	.reference(BalanceReference.create(request.getReference()))
.build();
}

	public static UpdateBalanceCommand toUpdateCommand(BalanceId id, BalanceRequest request) {
	return UpdateBalanceCommand.builder()
	.id(id)
		.name(BalanceName.create(request.getName()))
		.currency(BalanceCurrency.create(request.getCurrency()))
		.currentBalance(BalanceCurrentBalance.create(request.getCurrentBalance()))
		.previousBalance(BalancePreviousBalance.create(request.getPreviousBalance()))
		.lastUpdated(BalanceLastUpdated.create(request.getLastUpdated()))
		.isDefault(BalanceIsDefault.create(request.getIsDefault()))
		.ordre(BalanceOrdre.create(request.getOrdre()))
		.isArchived(BalanceIsArchived.create(request.getIsArchived()))
		.isAllowDebit(BalanceIsAllowDebit.create(request.getIsAllowDebit()))
		.isAllowCredit(BalanceIsAllowCredit.create(request.getIsAllowCredit()))
		.isExcluTotal(BalanceIsExcluTotal.create(request.getIsExcluTotal()))
		.activateNotification(BalanceActivateNotification.create(request.getActivateNotification()))
		.syncedAt(BalanceSyncedAt.create(request.getSyncedAt()))
		.updatedAt(BalanceUpdatedAt.create(request.getUpdatedAt()))
		.reference(BalanceReference.create(request.getReference()))
	.build();
	}


public static DeleteBalanceCommand toDeleteCommand(BalanceId id) {
return DeleteBalanceCommand.builder()
.id(id)
.build();
}
}
