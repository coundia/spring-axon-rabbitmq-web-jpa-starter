package com.groupe2cs.bizyhub.transactions.application.mapper;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;

public class TransactionMapper {

	public static TransactionResponse toResponse(Transaction entity) {
		return TransactionResponse.builder()
				.id(entity.getId())
				.name(entity.getName())
				.amount(entity.getAmount())
				.details(entity.getDetails())
				.isActive(entity.getIsActive())
				.account(entity.getAccount() != null ? entity.getAccount().getId() : null)
				.category(entity.getCategory() != null ? entity.getCategory().getId() : null)
				.typeTransactionRaw(entity.getTypeTransactionRaw())
				.dateTransaction(entity.getDateTransaction())
				.updatedAt(entity.getUpdatedAt())
				.reference(entity.getReference())
				.build();
	}

	public static TransactionResponse toResponse(CreateTransactionCommand command) {
		return TransactionResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.amount(command.getAmount().value())
				.details(command.getDetails().value())
				.isActive(command.getIsActive().value())
				.account(command.getAccount().value())
				.category(command.getCategory().value())
				.typeTransactionRaw(command.getTypeTransactionRaw().value())
				.dateTransaction(command.getDateTransaction().value())
				.updatedAt(command.getUpdatedAt().value())
				.reference(command.getReference().value())
				.build();
	}

	public static TransactionResponse toResponse(UpdateTransactionCommand command) {
		return TransactionResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.amount(command.getAmount().value())
				.details(command.getDetails().value())
				.isActive(command.getIsActive().value())
				.account(command.getAccount().value())
				.category(command.getCategory().value())
				.typeTransactionRaw(command.getTypeTransactionRaw().value())
				.dateTransaction(command.getDateTransaction().value())
				.updatedAt(command.getUpdatedAt().value())
				.reference(command.getReference().value())
				.build();
	}

	public static CreateTransactionCommand toCommand(
			TransactionRequest request
	) {
		return CreateTransactionCommand.builder()
				.name(TransactionName.create(request.getName()))
				.amount(TransactionAmount.create(request.getAmount()))
				.details(TransactionDetails.create(request.getDetails()))
				.isActive(TransactionIsActive.create(request.getIsActive()))
				.account(TransactionAccount.create(request.getAccount()))
				.category(TransactionCategory.create(request.getCategory()))
				.typeTransactionRaw(TransactionTypeTransactionRaw.create(request.getTypeTransactionRaw()))
				.dateTransaction(TransactionDateTransaction.create(request.getDateTransaction()))
				.updatedAt(TransactionUpdatedAt.create(request.getUpdatedAt()))
				.reference(TransactionReference.create(request.getReference()))
				.build();
	}

	public static UpdateTransactionCommand toUpdateCommand(TransactionId id, TransactionRequest request) {
		return UpdateTransactionCommand.builder()
				.id(id)
				.name(TransactionName.create(request.getName()))
				.amount(TransactionAmount.create(request.getAmount()))
				.details(TransactionDetails.create(request.getDetails()))
				.isActive(TransactionIsActive.create(request.getIsActive()))
				.account(TransactionAccount.create(request.getAccount()))
				.category(TransactionCategory.create(request.getCategory()))
				.typeTransactionRaw(TransactionTypeTransactionRaw.create(request.getTypeTransactionRaw()))
				.dateTransaction(TransactionDateTransaction.create(request.getDateTransaction()))
				.updatedAt(TransactionUpdatedAt.create(request.getUpdatedAt()))
				.reference(TransactionReference.create(request.getReference()))
				.build();
	}


	public static DeleteTransactionCommand toDeleteCommand(TransactionId id) {
		return DeleteTransactionCommand.builder()
				.id(id)
				.build();
	}
}
