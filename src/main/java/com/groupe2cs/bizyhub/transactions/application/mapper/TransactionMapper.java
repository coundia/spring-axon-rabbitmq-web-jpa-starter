package com.groupe2cs.bizyhub.transactions.application.mapper;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;

public class TransactionMapper {

	public static TransactionResponse toResponse(Transaction entity) {
		return TransactionResponse.builder()
				.id(entity.getId())
				.reference(entity.getReference())
				.amount(entity.getAmount())
				.build();
	}

	public static TransactionResponse toResponse(CreateTransactionCommand command) {
		return TransactionResponse.builder()
				.id(command.getId().value())
				.reference(command.getReference().value())
				.amount(command.getAmount().value())
				.build();
	}

	public static TransactionResponse toResponse(UpdateTransactionCommand command) {
		return TransactionResponse.builder()
				.id(command.getId().value())
				.reference(command.getReference().value())
				.amount(command.getAmount().value())
				.build();
	}

	public static CreateTransactionCommand toCommand(
			TransactionRequest request
	) {
		return CreateTransactionCommand.builder()
				.reference(TransactionReference.create(request.getReference()))
				.amount(TransactionAmount.create(request.getAmount()))
				.build();
	}

	public static UpdateTransactionCommand toUpdateCommand(TransactionId id, TransactionRequest request) {
		return UpdateTransactionCommand.builder()
				.id(id)
				.reference(TransactionReference.create(request.getReference()))
				.amount(TransactionAmount.create(request.getAmount()))
				.build();
	}


	public static DeleteTransactionCommand toDeleteCommand(TransactionId id) {
		return DeleteTransactionCommand.builder()
				.id(id)
				.build();
	}
}
