package com.groupe2cs.bizyhub.transactions.application.mapper;

	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.transactions.application.command.*;

public class TransactionUserMapper {

public static TransactionUserResponse toResponse(TransactionUser entity) {
return TransactionUserResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.transaction(entity.getTransaction() != null ? entity.getTransaction().getId() : null)
		.user(entity.getUser() != null ? entity.getUser().getId() : null)
		.username(entity.getUsername())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static TransactionUserResponse toResponse(CreateTransactionUserCommand command) {
return TransactionUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.transaction(command.getTransaction().value())
	.user(command.getUser().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static TransactionUserResponse toResponse(UpdateTransactionUserCommand command) {
return TransactionUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.transaction(command.getTransaction().value())
	.user(command.getUser().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateTransactionUserCommand toCommand(
TransactionUserRequest request
) {
return CreateTransactionUserCommand.builder()
	.name(TransactionUserName.create(request.getName()))
	.transaction(TransactionUserTransaction.create(request.getTransaction()))
	.user(TransactionUserUser.create(request.getUser()))
	.username(TransactionUserUsername.create(request.getUsername()))
	.details(TransactionUserDetails.create(request.getDetails()))
	.isActive(TransactionUserIsActive.create(request.getIsActive()))
	.updatedAt(TransactionUserUpdatedAt.create(request.getUpdatedAt()))
	.reference(TransactionUserReference.create(request.getReference()))
.build();
}

	public static UpdateTransactionUserCommand toUpdateCommand(TransactionUserId id, TransactionUserRequest request) {
	return UpdateTransactionUserCommand.builder()
	.id(id)
		.name(TransactionUserName.create(request.getName()))
		.transaction(TransactionUserTransaction.create(request.getTransaction()))
		.user(TransactionUserUser.create(request.getUser()))
		.username(TransactionUserUsername.create(request.getUsername()))
		.details(TransactionUserDetails.create(request.getDetails()))
		.isActive(TransactionUserIsActive.create(request.getIsActive()))
		.updatedAt(TransactionUserUpdatedAt.create(request.getUpdatedAt()))
		.reference(TransactionUserReference.create(request.getReference()))
	.build();
	}


public static DeleteTransactionUserCommand toDeleteCommand(TransactionUserId id) {
return DeleteTransactionUserCommand.builder()
.id(id)
.build();
}
}
