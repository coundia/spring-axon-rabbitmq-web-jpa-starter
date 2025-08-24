package com.groupe2cs.bizyhub.debts.application.mapper;

	import com.groupe2cs.bizyhub.debts.application.dto.*;
	import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
	import com.groupe2cs.bizyhub.debts.domain.*;
	import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.debts.application.command.*;

public class DebtMapper {

public static DebtResponse toResponse(Debt entity) {
return DebtResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.code(entity.getCode())
		.notes(entity.getNotes())
		.balance(entity.getBalance())
		.balanceDebt(entity.getBalanceDebt())
		.dueDate(entity.getDueDate())
		.statuses(entity.getStatuses())
		.syncAt(entity.getSyncAt())
		.customer(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
		.isActive(entity.getIsActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static DebtResponse toResponse(CreateDebtCommand command) {
return DebtResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.notes(command.getNotes().value())
	.balance(command.getBalance().value())
	.balanceDebt(command.getBalanceDebt().value())
	.dueDate(command.getDueDate().value())
	.statuses(command.getStatuses().value())
	.syncAt(command.getSyncAt().value())
	.customer(command.getCustomer().value())
	.isActive(command.getIsActive().value())
.build();
}

public static DebtResponse toResponse(UpdateDebtCommand command) {
return DebtResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.notes(command.getNotes().value())
	.balance(command.getBalance().value())
	.balanceDebt(command.getBalanceDebt().value())
	.dueDate(command.getDueDate().value())
	.statuses(command.getStatuses().value())
	.syncAt(command.getSyncAt().value())
	.customer(command.getCustomer().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateDebtCommand toCommand(
DebtRequest request
) {
return CreateDebtCommand.builder()
	.remoteId(DebtRemoteId.create(request.getRemoteId()))
	.localId(DebtLocalId.create(request.getLocalId()))
	.code(DebtCode.create(request.getCode()))
	.notes(DebtNotes.create(request.getNotes()))
	.balance(DebtBalance.create(request.getBalance()))
	.balanceDebt(DebtBalanceDebt.create(request.getBalanceDebt()))
	.dueDate(DebtDueDate.create(request.getDueDate()))
	.statuses(DebtStatuses.create(request.getStatuses()))
	.syncAt(DebtSyncAt.create(request.getSyncAt()))
	.customer(DebtCustomer.create(request.getCustomer()))
	.isActive(DebtIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateDebtCommand toUpdateCommand(DebtId id, DebtRequest request) {
	return UpdateDebtCommand.builder()
	.id(id)
		.remoteId(DebtRemoteId.create(request.getRemoteId()))
		.localId(DebtLocalId.create(request.getLocalId()))
		.code(DebtCode.create(request.getCode()))
		.notes(DebtNotes.create(request.getNotes()))
		.balance(DebtBalance.create(request.getBalance()))
		.balanceDebt(DebtBalanceDebt.create(request.getBalanceDebt()))
		.dueDate(DebtDueDate.create(request.getDueDate()))
		.statuses(DebtStatuses.create(request.getStatuses()))
		.syncAt(DebtSyncAt.create(request.getSyncAt()))
		.customer(DebtCustomer.create(request.getCustomer()))
		.isActive(DebtIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteDebtCommand toDeleteCommand(DebtId id) {
return DeleteDebtCommand.builder()
.id(id)
.build();
}
}
