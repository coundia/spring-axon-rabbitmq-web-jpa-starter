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
		return new TransactionResponse(
				entity.getId(),
				entity.getReference(),
				entity.getAmount()
		);
	}

	public static TransactionResponse toResponse(CreateTransactionCommand command) {
		return new TransactionResponse(
				command.getId().value(), command.getReference().value(), command.getAmount().value()
		);
	}

	public static TransactionResponse toResponse(UpdateTransactionCommand command) {
		return new TransactionResponse(
				command.getId().value(), command.getReference().value(), command.getAmount().value()
		);
	}


	public static CreateTransactionCommand toCommand(
			TransactionRequest request
	) {
		return new CreateTransactionCommand(
				TransactionReference.create(request.getReference()), TransactionAmount.create(request.getAmount())
		);
	}

	public static UpdateTransactionCommand toUpdateCommand(TransactionId id, TransactionRequest request) {
		return new UpdateTransactionCommand(
				id, TransactionReference.create(request.getReference()), TransactionAmount.create(request.getAmount())
		);
	}


	public static DeleteTransactionCommand toDeleteCommand(TransactionId id) {
		return new DeleteTransactionCommand(id);
	}
}
