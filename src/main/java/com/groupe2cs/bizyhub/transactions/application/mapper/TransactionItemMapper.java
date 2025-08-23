package com.groupe2cs.bizyhub.transactions.application.mapper;

	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.transactions.application.command.*;

public class TransactionItemMapper {

public static TransactionItemResponse toResponse(TransactionItem entity) {
return TransactionItemResponse.builder()
		.id(entity.getId())
		.transaction(entity.getTransaction() != null ? entity.getTransaction().getId() : null)
		.product(entity.getProduct() != null ? entity.getProduct().getId() : null)
		.label(entity.getLabel())
		.quantity(entity.getQuantity())
		.unit(entity.getUnit() != null ? entity.getUnit().getId() : null)
		.syncAt(entity.getSyncAt())
		.unitPrice(entity.getUnitPrice())
		.total(entity.getTotal())
		.notes(entity.getNotes())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static TransactionItemResponse toResponse(CreateTransactionItemCommand command) {
return TransactionItemResponse.builder()
	.id(command.getId().value())
	.transaction(command.getTransaction().value())
	.product(command.getProduct().value())
	.label(command.getLabel().value())
	.quantity(command.getQuantity().value())
	.unit(command.getUnit().value())
	.syncAt(command.getSyncAt().value())
	.unitPrice(command.getUnitPrice().value())
	.total(command.getTotal().value())
	.notes(command.getNotes().value())
.build();
}

public static TransactionItemResponse toResponse(UpdateTransactionItemCommand command) {
return TransactionItemResponse.builder()
	.id(command.getId().value())
	.transaction(command.getTransaction().value())
	.product(command.getProduct().value())
	.label(command.getLabel().value())
	.quantity(command.getQuantity().value())
	.unit(command.getUnit().value())
	.syncAt(command.getSyncAt().value())
	.unitPrice(command.getUnitPrice().value())
	.total(command.getTotal().value())
	.notes(command.getNotes().value())
.build();
}

public static CreateTransactionItemCommand toCommand(
TransactionItemRequest request
) {
return CreateTransactionItemCommand.builder()
	.transaction(TransactionItemTransaction.create(request.getTransaction()))
	.product(TransactionItemProduct.create(request.getProduct()))
	.label(TransactionItemLabel.create(request.getLabel()))
	.quantity(TransactionItemQuantity.create(request.getQuantity()))
	.unit(TransactionItemUnit.create(request.getUnit()))
	.syncAt(TransactionItemSyncAt.create(request.getSyncAt()))
	.unitPrice(TransactionItemUnitPrice.create(request.getUnitPrice()))
	.total(TransactionItemTotal.create(request.getTotal()))
	.notes(TransactionItemNotes.create(request.getNotes()))
.build();
}

	public static UpdateTransactionItemCommand toUpdateCommand(TransactionItemId id, TransactionItemRequest request) {
	return UpdateTransactionItemCommand.builder()
	.id(id)
		.transaction(TransactionItemTransaction.create(request.getTransaction()))
		.product(TransactionItemProduct.create(request.getProduct()))
		.label(TransactionItemLabel.create(request.getLabel()))
		.quantity(TransactionItemQuantity.create(request.getQuantity()))
		.unit(TransactionItemUnit.create(request.getUnit()))
		.syncAt(TransactionItemSyncAt.create(request.getSyncAt()))
		.unitPrice(TransactionItemUnitPrice.create(request.getUnitPrice()))
		.total(TransactionItemTotal.create(request.getTotal()))
		.notes(TransactionItemNotes.create(request.getNotes()))
	.build();
	}


public static DeleteTransactionItemCommand toDeleteCommand(TransactionItemId id) {
return DeleteTransactionItemCommand.builder()
.id(id)
.build();
}
}
