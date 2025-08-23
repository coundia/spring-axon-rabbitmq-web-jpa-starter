package com.groupe2cs.bizyhub.transactions.application.mapper;

	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.transactions.application.command.*;

public class TransactionEntryMapper {

public static TransactionEntryResponse toResponse(TransactionEntry entity) {
return TransactionEntryResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.code(entity.getCode())
		.description(entity.getDescription())
		.amount(entity.getAmount())
		.typeEntry(entity.getTypeEntry())
		.dateTransaction(entity.getDateTransaction())
		.status(entity.getStatus())
		.entityName(entity.getEntityName())
		.entityId(entity.getEntityId())
		.account(entity.getAccount() != null ? entity.getAccount().getId() : null)
		.syncAt(entity.getSyncAt())
		.category(entity.getCategory() != null ? entity.getCategory().getId() : null)
		.company(entity.getCompany() != null ? entity.getCompany().getId() : null)
		.customer(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
		.debt(entity.getDebt() != null ? entity.getDebt().getId() : null)
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static TransactionEntryResponse toResponse(CreateTransactionEntryCommand command) {
return TransactionEntryResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.code(command.getCode().value())
	.description(command.getDescription().value())
	.amount(command.getAmount().value())
	.typeEntry(command.getTypeEntry().value())
	.dateTransaction(command.getDateTransaction().value())
	.status(command.getStatus().value())
	.entityName(command.getEntityName().value())
	.entityId(command.getEntityId().value())
	.account(command.getAccount().value())
	.syncAt(command.getSyncAt().value())
	.category(command.getCategory().value())
	.company(command.getCompany().value())
	.customer(command.getCustomer().value())
	.debt(command.getDebt().value())
.build();
}

public static TransactionEntryResponse toResponse(UpdateTransactionEntryCommand command) {
return TransactionEntryResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.code(command.getCode().value())
	.description(command.getDescription().value())
	.amount(command.getAmount().value())
	.typeEntry(command.getTypeEntry().value())
	.dateTransaction(command.getDateTransaction().value())
	.status(command.getStatus().value())
	.entityName(command.getEntityName().value())
	.entityId(command.getEntityId().value())
	.account(command.getAccount().value())
	.syncAt(command.getSyncAt().value())
	.category(command.getCategory().value())
	.company(command.getCompany().value())
	.customer(command.getCustomer().value())
	.debt(command.getDebt().value())
.build();
}

public static CreateTransactionEntryCommand toCommand(
TransactionEntryRequest request
) {
return CreateTransactionEntryCommand.builder()
	.remoteId(TransactionEntryRemoteId.create(request.getRemoteId()))
	.code(TransactionEntryCode.create(request.getCode()))
	.description(TransactionEntryDescription.create(request.getDescription()))
	.amount(TransactionEntryAmount.create(request.getAmount()))
	.typeEntry(TransactionEntryTypeEntry.create(request.getTypeEntry()))
	.dateTransaction(TransactionEntryDateTransaction.create(request.getDateTransaction()))
	.status(TransactionEntryStatus.create(request.getStatus()))
	.entityName(TransactionEntryEntityName.create(request.getEntityName()))
	.entityId(TransactionEntryEntityId.create(request.getEntityId()))
	.account(TransactionEntryAccount.create(request.getAccount()))
	.syncAt(TransactionEntrySyncAt.create(request.getSyncAt()))
	.category(TransactionEntryCategory.create(request.getCategory()))
	.company(TransactionEntryCompany.create(request.getCompany()))
	.customer(TransactionEntryCustomer.create(request.getCustomer()))
	.debt(TransactionEntryDebt.create(request.getDebt()))
.build();
}

	public static UpdateTransactionEntryCommand toUpdateCommand(TransactionEntryId id, TransactionEntryRequest request) {
	return UpdateTransactionEntryCommand.builder()
	.id(id)
		.remoteId(TransactionEntryRemoteId.create(request.getRemoteId()))
		.code(TransactionEntryCode.create(request.getCode()))
		.description(TransactionEntryDescription.create(request.getDescription()))
		.amount(TransactionEntryAmount.create(request.getAmount()))
		.typeEntry(TransactionEntryTypeEntry.create(request.getTypeEntry()))
		.dateTransaction(TransactionEntryDateTransaction.create(request.getDateTransaction()))
		.status(TransactionEntryStatus.create(request.getStatus()))
		.entityName(TransactionEntryEntityName.create(request.getEntityName()))
		.entityId(TransactionEntryEntityId.create(request.getEntityId()))
		.account(TransactionEntryAccount.create(request.getAccount()))
		.syncAt(TransactionEntrySyncAt.create(request.getSyncAt()))
		.category(TransactionEntryCategory.create(request.getCategory()))
		.company(TransactionEntryCompany.create(request.getCompany()))
		.customer(TransactionEntryCustomer.create(request.getCustomer()))
		.debt(TransactionEntryDebt.create(request.getDebt()))
	.build();
	}


public static DeleteTransactionEntryCommand toDeleteCommand(TransactionEntryId id) {
return DeleteTransactionEntryCommand.builder()
.id(id)
.build();
}
}
