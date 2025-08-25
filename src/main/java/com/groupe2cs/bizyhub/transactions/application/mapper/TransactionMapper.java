package com.groupe2cs.bizyhub.transactions.application.mapper;

	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.transactions.application.command.*;

public class TransactionMapper {

public static TransactionResponse toResponse(Transaction entity) {
return TransactionResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
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

public static TransactionResponse toResponse(CreateTransactionCommand command) {
return TransactionResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
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

public static TransactionResponse toResponse(UpdateTransactionCommand command) {
return TransactionResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
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

public static CreateTransactionCommand toCommand(
TransactionRequest request
) {
return CreateTransactionCommand.builder()
	.remoteId(TransactionRemoteId.create(request.getRemoteId()))
	.localId(TransactionLocalId.create(request.getLocalId()))
	.code(TransactionCode.create(request.getCode()))
	.description(TransactionDescription.create(request.getDescription()))
	.amount(TransactionAmount.create(request.getAmount()))
	.typeEntry(TransactionTypeEntry.create(request.getTypeEntry()))
	.dateTransaction(TransactionDateTransaction.create(request.getDateTransaction()))
	.status(TransactionStatus.create(request.getStatus()))
	.entityName(TransactionEntityName.create(request.getEntityName()))
	.entityId(TransactionEntityId.create(request.getEntityId()))
	.account(TransactionAccount.create(request.getAccount()))
	.syncAt(TransactionSyncAt.create(request.getSyncAt()))
	.category(TransactionCategory.create(request.getCategory()))
	.company(TransactionCompany.create(request.getCompany()))
	.customer(TransactionCustomer.create(request.getCustomer()))
	.debt(TransactionDebt.create(request.getDebt()))
.build();
}

	public static UpdateTransactionCommand toUpdateCommand(TransactionId id, TransactionRequest request) {
	return UpdateTransactionCommand.builder()
	.id(id)
		.remoteId(TransactionRemoteId.create(request.getRemoteId()))
		.localId(TransactionLocalId.create(request.getLocalId()))
		.code(TransactionCode.create(request.getCode()))
		.description(TransactionDescription.create(request.getDescription()))
		.amount(TransactionAmount.create(request.getAmount()))
		.typeEntry(TransactionTypeEntry.create(request.getTypeEntry()))
		.dateTransaction(TransactionDateTransaction.create(request.getDateTransaction()))
		.status(TransactionStatus.create(request.getStatus()))
		.entityName(TransactionEntityName.create(request.getEntityName()))
		.entityId(TransactionEntityId.create(request.getEntityId()))
		.account(TransactionAccount.create(request.getAccount()))
		.syncAt(TransactionSyncAt.create(request.getSyncAt()))
		.category(TransactionCategory.create(request.getCategory()))
		.company(TransactionCompany.create(request.getCompany()))
		.customer(TransactionCustomer.create(request.getCustomer()))
		.debt(TransactionDebt.create(request.getDebt()))
	.build();
	}


public static DeleteTransactionCommand toDeleteCommand(TransactionId id) {
return DeleteTransactionCommand.builder()
.id(id)
.build();
}
}
