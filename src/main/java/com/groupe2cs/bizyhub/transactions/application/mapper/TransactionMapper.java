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
		.amount(entity.getAmount())
		.dateOperation(entity.getDateOperation())
		.description(entity.getDescription())
		.reference(entity.getReference())
		.isRecurring(entity.getIsRecurring())
		.isExcluToRapport(entity.getIsExcluToRapport())
		.status(entity.getStatus())
		.balance(entity.getBalance() != null ? entity.getBalance().getId() : null)
		.category(entity.getCategory() != null ? entity.getCategory().getId() : null)
		.updatedAt(entity.getUpdatedAt())
		.createdAt(entity.getCreatedAt())
.build();
}

public static TransactionResponse toResponse(CreateTransactionCommand command) {
return TransactionResponse.builder()
	.id(command.getId().value())
	.amount(command.getAmount().value())
	.dateOperation(command.getDateOperation().value())
	.description(command.getDescription().value())
	.reference(command.getReference().value())
	.isRecurring(command.getIsRecurring().value())
	.isExcluToRapport(command.getIsExcluToRapport().value())
	.status(command.getStatus().value())
	.balance(command.getBalance().value())
	.category(command.getCategory().value())
	.updatedAt(command.getUpdatedAt().value())
	.createdAt(command.getCreatedAt().value())
.build();
}

public static TransactionResponse toResponse(UpdateTransactionCommand command) {
return TransactionResponse.builder()
	.id(command.getId().value())
	.amount(command.getAmount().value())
	.dateOperation(command.getDateOperation().value())
	.description(command.getDescription().value())
	.reference(command.getReference().value())
	.isRecurring(command.getIsRecurring().value())
	.isExcluToRapport(command.getIsExcluToRapport().value())
	.status(command.getStatus().value())
	.balance(command.getBalance().value())
	.category(command.getCategory().value())
	.updatedAt(command.getUpdatedAt().value())
	.createdAt(command.getCreatedAt().value())
.build();
}

public static CreateTransactionCommand toCommand(
TransactionRequest request
) {
return CreateTransactionCommand.builder()
	.amount(TransactionAmount.create(request.getAmount()))
	.dateOperation(TransactionDateOperation.create(request.getDateOperation()))
	.description(TransactionDescription.create(request.getDescription()))
	.reference(TransactionReference.create(request.getReference()))
	.isRecurring(TransactionIsRecurring.create(request.getIsRecurring()))
	.isExcluToRapport(TransactionIsExcluToRapport.create(request.getIsExcluToRapport()))
	.status(TransactionStatus.create(request.getStatus()))
	.balance(TransactionBalance.create(request.getBalance()))
	.category(TransactionCategory.create(request.getCategory()))
	.updatedAt(TransactionUpdatedAt.create(request.getUpdatedAt()))
	.createdAt(TransactionCreatedAt.create(request.getCreatedAt()))
.build();
}

	public static UpdateTransactionCommand toUpdateCommand(TransactionId id, TransactionRequest request) {
	return UpdateTransactionCommand.builder()
	.id(id)
		.amount(TransactionAmount.create(request.getAmount()))
		.dateOperation(TransactionDateOperation.create(request.getDateOperation()))
		.description(TransactionDescription.create(request.getDescription()))
		.reference(TransactionReference.create(request.getReference()))
		.isRecurring(TransactionIsRecurring.create(request.getIsRecurring()))
		.isExcluToRapport(TransactionIsExcluToRapport.create(request.getIsExcluToRapport()))
		.status(TransactionStatus.create(request.getStatus()))
		.balance(TransactionBalance.create(request.getBalance()))
		.category(TransactionCategory.create(request.getCategory()))
		.updatedAt(TransactionUpdatedAt.create(request.getUpdatedAt()))
		.createdAt(TransactionCreatedAt.create(request.getCreatedAt()))
	.build();
	}


public static DeleteTransactionCommand toDeleteCommand(TransactionId id) {
return DeleteTransactionCommand.builder()
.id(id)
.build();
}
}
