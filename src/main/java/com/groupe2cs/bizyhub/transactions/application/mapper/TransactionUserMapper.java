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
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.transaction(entity.getTransaction())
		.user(entity.getUser())
		.syncAt(entity.getSyncAt())
		.username(entity.getUsername())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static TransactionUserResponse toResponse(CreateTransactionUserCommand command) {
return TransactionUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.transaction(command.getTransaction().value())
	.user(command.getUser().value())
	.syncAt(command.getSyncAt().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
.build();
}

public static TransactionUserResponse toResponse(UpdateTransactionUserCommand command) {
return TransactionUserResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.transaction(command.getTransaction().value())
	.user(command.getUser().value())
	.syncAt(command.getSyncAt().value())
	.username(command.getUsername().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateTransactionUserCommand toCommand(
TransactionUserRequest request
) {
return CreateTransactionUserCommand.builder()
	.name(TransactionUserName.create(request.getName()))
	.remoteId(TransactionUserRemoteId.create(request.getRemoteId()))
	.localId(TransactionUserLocalId.create(request.getLocalId()))
	.transaction(TransactionUserTransaction.create(request.getTransaction()))
	.user(TransactionUserUser.create(request.getUser()))
	.syncAt(TransactionUserSyncAt.create(request.getSyncAt()))
	.username(TransactionUserUsername.create(request.getUsername()))
	.details(TransactionUserDetails.create(request.getDetails()))
	.isActive(TransactionUserIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateTransactionUserCommand toUpdateCommand(TransactionUserId id, TransactionUserRequest request) {
	return UpdateTransactionUserCommand.builder()
	.id(id)
		.name(TransactionUserName.create(request.getName()))
		.remoteId(TransactionUserRemoteId.create(request.getRemoteId()))
		.localId(TransactionUserLocalId.create(request.getLocalId()))
		.transaction(TransactionUserTransaction.create(request.getTransaction()))
		.user(TransactionUserUser.create(request.getUser()))
		.syncAt(TransactionUserSyncAt.create(request.getSyncAt()))
		.username(TransactionUserUsername.create(request.getUsername()))
		.details(TransactionUserDetails.create(request.getDetails()))
		.isActive(TransactionUserIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteTransactionUserCommand toDeleteCommand(TransactionUserId id) {
return DeleteTransactionUserCommand.builder()
.id(id)
.build();
}
}
